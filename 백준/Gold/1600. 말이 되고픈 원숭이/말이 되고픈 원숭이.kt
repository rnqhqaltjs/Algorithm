import java.util.LinkedList

val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val k = br.readLine().toInt()
    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val graph = Array(m) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }

    bfs(0, 0, graph, k)

    close()
}

fun bfs(sX: Int, sY: Int, graph: Array<IntArray>, k: Int) {
    val q = LinkedList<Triple<Int,Int, Int>>()
    q.add(Triple(sX, sY, k))
    val v = Array(graph.size) { Array(graph[0].size) { IntArray(k + 1) { 0 } } }

    v[sX][sY][k] = 1


    val directions = listOf(
        Pair(-1, 0), Pair(1, 0), Pair(0, -1), Pair(0, 1)
    )
    val jumps = listOf(
        Pair(-1, -2), Pair(-2, -1), Pair(-1, 2), Pair(-2, 1),
        Pair(1, 2), Pair(2, 1), Pair(1, -2), Pair(2, -1)
    )

    while (q.isNotEmpty()) {
        val (cX, cY, cK) = q.poll()

        if(cX == graph.size -1 && cY == graph[0].size -1) {
            print("${v[cX][cY][cK] - 1}")
            return
        }

        if (cK > 0) {
            for ((jx, jy) in jumps) {
                val newX = cX + jx
                val newY = cY + jy
                if (newX in graph.indices && newY in graph[0].indices && graph[newX][newY] == 0 && v[newX][newY][cK -1] == 0) {
                    q.add(Triple(newX, newY, cK - 1))
                    v[newX][newY][cK - 1] = v[cX][cY][cK] + 1
                }
            }
        }

        for ((dx, dy) in directions) {
            val newX = cX + dx
            val newY = cY + dy
            if (newX in graph.indices && newY in graph[0].indices && graph[newX][newY] == 0 && v[newX][newY][cK] == 0) {
                q.add(Triple(newX, newY, cK))
                v[newX][newY][cK] = v[cX][cY][cK] + 1
            }
        }
    }

    print("-1")
}