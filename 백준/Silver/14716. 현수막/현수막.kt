import java.util.LinkedList

val br = System.`in`.bufferedReader()

val dX = arrayOf(-1, 0, 1, 0, -1, -1, 1, 1)
val dY = arrayOf(0, 1, 0, -1, -1, 1, -1, 1)

fun main() = with(System.out.bufferedWriter()) {
    var count = 0
    val (m, n) = br.readLine().split(" ").map { it.toInt() }
    val graph = Array(m) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }
    val visited = Array(m) { BooleanArray(n) }

    for (i in 0 until m) {
        for (j in 0 until n) {
            if (!visited[i][j] && graph[i][j] == 1) {
                bfs(i, j, graph, visited)
                count++
            }
        }
    }

    write("$count\n")

    close()
}

fun bfs(sX: Int, sY: Int, graph: Array<IntArray>, v: Array<BooleanArray>) {
    val q = LinkedList<Pair<Int, Int>>()
    v[sX][sY] = true
    q.offer(sX to sY)

    while (q.isNotEmpty()) {
        val (cX, cY) = q.poll()
        for (i in 0 until 8) {
            val nX = cX + dX[i]
            val nY = cY + dY[i]

            if (nX in graph.indices && nY in graph[0].indices) {
                if (!v[nX][nY] && graph[nX][nY] == 1) {
                    v[nX][nY] = true
                    q.offer(nX to nY)
                }
            }
        }
    }
}