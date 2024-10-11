import java.util.LinkedList

val br = System.`in`.bufferedReader()

val dX = arrayOf(-1, 0, 1, 0)
val dY = arrayOf(0, 1, 0, -1)

fun main() = with(System.out.bufferedWriter()) {
    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val graph = Array(n) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }
    val visited = Array(n) { IntArray(m) { -1 } }

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (graph[i][j] == 2 && visited[i][j] == -1) {
                bfs(i, j, graph, visited)
            }
        }
    }

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (graph[i][j] == 0) {
                write("0\n")
            } else {
                write("${visited[i][j]}\n")
            }
        }
    }
    close()
}

fun bfs(sX: Int, sY: Int, graph: Array<IntArray>, v: Array<IntArray>) {
    val q = LinkedList<Pair<Int, Int>>()
    v[sX][sY] = 0
    q.offer(sX to sY)

    while (q.isNotEmpty()) {
        val (cX, cY) = q.poll()

        for (i in 0 until 4) {
            val nX = cX + dX[i]
            val nY = cY + dY[i]

            if (nX in graph.indices && nY in graph[0].indices && v[nX][nY] == -1) {
                if (graph[nX][nY] == 0) {
                    v[nX][nY] = 0
                } else if (graph[nX][nY] == 1) {
                    v[nX][nY] = v[cX][cY] + 1
                    q.offer(nX to nY)
                }
            }
        }
    }
}