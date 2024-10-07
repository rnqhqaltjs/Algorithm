import java.util.LinkedList

val br = System.`in`.bufferedReader()

val dX = arrayOf(-1, 0, 1, 0, -1, -1, 1, 1)
val dY = arrayOf(0, 1, 0, -1, -1, 1, -1, 1)

fun main() = with(System.out.bufferedWriter()) {
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val graph = Array(n) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }
    val visited = Array(n) { BooleanArray(m) }

    var count = 0
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (graph[i][j] > 0 && !visited[i][j]) {
                if (bfs(i, j, graph, visited)) {
                    count++
                }
            }
        }
    }

    write("$count")
    close()
}

fun bfs(sX: Int, sY: Int, graph: Array<IntArray>, v: Array<BooleanArray>): Boolean {
    val q = LinkedList<Pair<Int, Int>>()
    v[sX][sY] = true
    val height = graph[sX][sY]
    q.offer(sX to sY)
    var isTop = true

    while (q.isNotEmpty()) {
        val (cX, cY) = q.poll()

        for (i in 0 until 8) {
            val nX = cX + dX[i]
            val nY = cY + dY[i]

            if (nX in graph.indices && nY in graph[0].indices) {
                if (graph[nX][nY] > height) {
                    isTop = false
                } else if (!v[nX][nY] && graph[nX][nY] == height) {
                    v[nX][nY] = true
                    q.add(nX to nY)
                }
            }
        }
    }
    return isTop
}