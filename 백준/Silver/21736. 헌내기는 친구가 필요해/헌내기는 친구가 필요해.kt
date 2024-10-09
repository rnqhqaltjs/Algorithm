import java.util.LinkedList

val br = System.`in`.bufferedReader()

val dX = arrayOf(-1, 0, 1, 0)
val dY = arrayOf(0, 1, 0, -1)

var count = 0

fun main() = with(System.out.bufferedWriter()) {
    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val graph = Array(n) { br.readLine().toCharArray() }
    val visited = Array(n) { BooleanArray(m) }

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (graph[i][j] == 'I') {
                bfs(i, j, graph, visited)
            }
        }
    }

    if(count == 0) {
        write("TT")
    } else {
        write("$count")
    }
    close()
}

fun bfs(sX: Int, sY: Int, graph: Array<CharArray>, v: Array<BooleanArray>) {
    val q = LinkedList<Pair<Int, Int>>()
    v[sX][sY] = true
    q.offer(sX to sY)

    while (q.isNotEmpty()) {
        val (cX, cY) = q.poll()

        if(graph[cX][cY] == 'P') {
            count++
        }

        for (i in 0 until 4) {
            val nX = cX + dX[i]
            val nY = cY + dY[i]

            if (nX in graph.indices && nY in graph[0].indices) {
                if (!v[nX][nY] && graph[nX][nY] != 'X') {
                    v[nX][nY] = true
                    q.offer(nX to nY)
                }
            }
        }
    }
}