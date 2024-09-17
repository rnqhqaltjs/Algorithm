import java.util.LinkedList
import kotlin.math.max

val br = System.`in`.bufferedReader()

val dx = arrayOf(-1, 0, 1, 0)
val dy = arrayOf(0, 1, 0, -1)

var area = 0
var count = 0
var max = 0

fun main() = with(System.out.bufferedWriter()) {
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val graph = Array(n) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }
    val visited = Array(n) { BooleanArray(m) }

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (graph[i][j] == 1 && !visited[i][j]) {
                bfs(i, j, graph, visited)
                count++
            }
        }
    }

    write("$count\n")
    write("$max")
    close()
}

fun bfs(si: Int, sj: Int, graph: Array<IntArray>, v: Array<BooleanArray>) {
    val q = LinkedList<Pair<Int, Int>>()
    q.add(si to sj)
    v[si][sj] = true
    area = 1

    while (q.isNotEmpty()) {
        val (ci, cj) = q.poll()

        for(i in 0 until 4) {
            val nx = ci + dx[i]
            val ny = cj + dy[i]

            if(nx in graph.indices && ny in graph[0].indices && !v[nx][ny] && graph[nx][ny] == 1) {
                q.add(nx to ny)
                v[nx][ny] = true
                area++
            }
        }
    }
    max = max(max, area)
}