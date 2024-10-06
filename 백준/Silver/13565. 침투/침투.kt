import java.util.LinkedList

val br = System.`in`.bufferedReader()

val dX = arrayOf(-1, 0, 1, 0)
val dY = arrayOf(0, 1, 0, -1)

fun main() = with(System.out.bufferedWriter()) {
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val graph = Array(n) { br.readLine().map { it - '0' }.toIntArray() }

    for (j in 0 until m) {
        if (graph[0][j] == 0) {
            if (bfs(0, j, graph)) {
                write("YES")
                close()
                return@with
            }
        }
    }
    write("NO")
    close()
}

fun bfs(sX: Int, sY: Int, graph: Array<IntArray>): Boolean {
    val q = LinkedList<Pair<Int, Int>>()
    graph[sX][sY] = 1
    q.offer(sX to sY)

    while (q.isNotEmpty()) {
        val (cX, cY) = q.poll()

        if (cX == graph.size - 1) {
            return true
        }

        for (i in 0 until 4) {
            val nX = cX + dX[i]
            val nY = cY + dY[i]

            if (nX in graph.indices && nY in graph[0].indices) {
                if (graph[nX][nY] == 0) {
                    graph[nX][nY] = 1
                    q.offer(nX to nY)
                }
            }
        }
    }

    return false
}