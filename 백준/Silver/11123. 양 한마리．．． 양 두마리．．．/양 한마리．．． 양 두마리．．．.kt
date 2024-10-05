import java.util.LinkedList

val br = System.`in`.bufferedReader()

val dX = arrayOf(-1, 0, 1, 0)
val dY = arrayOf(0, 1, 0, -1)

fun main() = with(System.out.bufferedWriter()) {
    val t = br.readLine().toInt()

    repeat(t) {
        var count = 0
        val (h, w) = br.readLine().split(" ").map { it.toInt() }
        val graph = Array(h) { br.readLine().toCharArray() }
        val visited = Array(h) { BooleanArray(w) }

        for (i in 0 until h) {
            for (j in 0 until w) {
                if (!visited[i][j] && graph[i][j] == '#') {
                    bfs(i, j, graph, visited)
                    count++
                }
            }
        }

        write("$count\n")
    }


    close()
}

fun bfs(sX: Int, sY: Int, graph: Array<CharArray>, v: Array<BooleanArray>) {
    val q = LinkedList<Pair<Int, Int>>()
    v[sX][sY] = true
    q.offer(sX to sY)

    while (q.isNotEmpty()) {
        val (cX, cY) = q.poll()
        for (i in 0 until 4) {
            val nX = cX + dX[i]
            val nY = cY + dY[i]

            if (nX in graph.indices && nY in graph[0].indices) {
                if (!v[nX][nY] && graph[nX][nY] == '#') {
                    v[nX][nY] = true
                    q.offer(nX to nY)
                }
            }
        }
    }
}