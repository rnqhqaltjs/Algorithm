import java.util.LinkedList
import kotlin.math.max

val br = System.`in`.bufferedReader()

val dX = arrayOf(-1, 0, 1, 0, -1, -1, 1, 1)
val dY = arrayOf(0, 1, 0, -1, -1, 1, -1, 1)

fun main() = with(System.out.bufferedWriter()) {
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val graph = Array(n) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }
    
    var answer = 0
    for (i in 0 until n) {
        for (j in 0 until m) {
            val visited = Array(n) { BooleanArray(m) }
            if (graph[i][j] == 0) {
                answer = max(answer, bfs(i, j, graph, visited))
            }
        }
    }

    write("$answer\n")

    close()
}

fun bfs(sX: Int, sY: Int, graph: Array<IntArray>, v: Array<BooleanArray>): Int {
    val q = LinkedList<Triple<Int, Int, Int>>()
    v[sX][sY] = true
    q.offer(Triple(sX, sY, 0))

    while (q.isNotEmpty()) {
        val (cX, cY, count) = q.poll()
        for (i in 0 until 8) {
            val nX = cX + dX[i]
            val nY = cY + dY[i]

            if (nX in graph.indices && nY in graph[0].indices && !v[nX][nY]) {
                if (graph[nX][nY] == 0) {
                    v[nX][nY] = true
                    q.offer(Triple(nX, nY, count + 1))
                } else {
                    return count + 1
                }
            }
        }
    }

    return -1
}