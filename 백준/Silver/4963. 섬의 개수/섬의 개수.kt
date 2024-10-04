import java.util.LinkedList

val br = System.`in`.bufferedReader()
val dX = arrayOf(-1, 0, 1, 0, -1, -1, 1, 1)
val dY = arrayOf(0, 1, 0, -1, -1, 1, -1, 1)
fun main() = with(System.out.bufferedWriter()) {
    while (true) {
        val (w, h) = br.readLine().split(" ").map { it.toInt() }
        var count = 0

        if (w == 0 && h == 0) {
            break
        }

        val graph = Array(h) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }
        val visited = Array(h) { BooleanArray(w) }

        for (i in 0 until h) {
            for (j in 0 until w) {
                if (!visited[i][j] && graph[i][j] == 1) {
                    bfs(i, j, graph, visited)
                    count++
                }
            }
        }

        write("$count\n")
    }
    close()
}

fun bfs(sX: Int, sY: Int, graph: Array<IntArray>, v: Array<BooleanArray>) {
    val q = LinkedList<Pair<Int, Int>>()
    q.add(Pair(sX, sY))
    v[sX][sY] = true

    while (q.isNotEmpty()) {
        val (cX, cY) = q.poll()

        for (i in 0 until 8) {
            val nX = cX + dX[i]
            val nY = cY + dY[i]

            if (nX in graph.indices && nY in graph[0].indices) {
                if (!v[nX][nY] && graph[nX][nY] == 1) {
                    q.add(Pair(nX, nY))
                    v[nX][nY] = true
                }
            }
        }
    }
}