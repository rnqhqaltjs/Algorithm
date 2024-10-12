import java.util.LinkedList

val br = System.`in`.bufferedReader()
val q = LinkedList<Triple<Int, Int, Int>>()

val dX = arrayOf(-1, 0, 1, 0, 0, 0)
val dY = arrayOf(0, 1, 0, -1, 0, 0)
val dZ = arrayOf(0, 0, 0, 0, -1, 1)

fun main() = with(System.out.bufferedWriter()) {
    val (m, n, h) = br.readLine().split(" ").map { it.toInt() }
    val graph = Array(h) { Array(n) { IntArray(m) } }
    var max = 0

    for (i in 0 until h) {
        for (j in 0 until n) {
            val line = br.readLine().split(" ").map { it.toInt() }
            for (k in 0 until m) {
                graph[i][j][k] = line[k]
            }
        }
    }

    for (i in 0 until h) {
        for (j in 0 until n) {
            for (k in 0 until m) {
                if (graph[i][j][k] == 1) {
                    q.add(Triple(i, j, k))
                }
            }
        }
    }

    bfs(graph)

    for (i in 0 until h) {
        for (j in 0 until n) {
            for (k in 0 until m) {
                if (graph[i][j][k] == 0) {
                    write("-1")
                    close()
                    return
                }
                if (graph[i][j][k] > max) {
                    max = graph[i][j][k]
                }
            }
        }
    }

    write("${max - 1}")
    close()
}

fun bfs(graph: Array<Array<IntArray>>) {
    while (q.isNotEmpty()) {
        val (cZ, cX, cY) = q.poll()

        for (i in 0 until 6) {
            val nz = cZ + dZ[i]
            val nx = cX + dX[i]
            val ny = cY + dY[i]

            if (nz in graph.indices && nx in graph[nz].indices && ny in graph[nz][nx].indices && graph[nz][nx][ny] == 0) {
                graph[nz][nx][ny] = graph[cZ][cX][cY] + 1
                q.add(Triple(nz, nx, ny))
            }
        }
    }
}