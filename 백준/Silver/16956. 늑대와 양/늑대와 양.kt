val br = System.`in`.bufferedReader()

val dX = arrayOf(-1, 0, 1, 0)
val dY = arrayOf(0, 1, 0, -1)
var flag = 1

fun main() = with(System.out.bufferedWriter()) {
    val (r, c) = br.readLine().split(" ").map { it.toInt() }
    val graph = Array(r) { br.readLine().toCharArray() }

    for (i in 0 until r) {
        for (j in 0 until c) {
            if (graph[i][j] == 'S') {
                bfs(i, j, graph)
            }
        }
    }

    if (flag == 1) {
        write("$flag\n")
        for(i in 0 until r) {
            write(graph[i])
            write("\n")
        }
    } else {
        write("$flag\n")
    }
    close()
}

fun bfs(sX: Int, sY: Int, graph: Array<CharArray>) {
    for (i in 0 until 4) {
        val nX = dX[i] + sX
        val nY = dY[i] + sY

        if (nX in graph.indices && nY in graph[0].indices) {
            if (graph[nX][nY] == '.') {
                graph[nX][nY] = 'D'
            } else if (graph[nX][nY] == 'W') {
                flag = 0
                break
            }
        }
    }
}