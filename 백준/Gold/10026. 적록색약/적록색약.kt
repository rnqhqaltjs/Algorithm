import java.util.LinkedList

val br = System.`in`.bufferedReader()

val dx = arrayOf(-1, 0, 1, 0)
val dy = arrayOf(0, 1, 0, -1)

var count = 0
var count2 = 0

lateinit var visited: Array<BooleanArray>

fun main() = with(System.out.bufferedWriter()) {
    val n = br.readLine().toInt()
    val graph = Array(n) { br.readLine().toCharArray() }
    visited = Array(n) { BooleanArray(n) { false } }

    for (i in 0 until n) {
        for (j in 0 until n) {
            if(!visited[i][j]) {
                bfs(i, j, graph, graph[i][j])
                count++
            }
        }
    }

    visited = Array(n) { BooleanArray(n) { false } }

    for (i in 0 until n) {
        for (j in 0 until n) {
            if(!visited[i][j]) {
                bfs2(i, j, graph, graph[i][j])
                count2++
            }
        }
    }
    write("$count $count2\n")
    close()
}

fun bfs(si: Int, sj: Int, graph: Array<CharArray>, node: Char) {
    val q = LinkedList<Pair<Int, Int>>()
    q.offer(si to sj)
    visited[si][sj] = true

    while (q.isNotEmpty()) {
        val (ci, cj) = q.poll()

        for (i in 0 until 4) {
            val nx = ci + dx[i]
            val ny = cj + dy[i]

            if (nx in graph.indices && ny in graph[0].indices && !visited[nx][ny]) {
                if (node == graph[nx][ny]) {
                    q.offer(nx to ny)
                    visited[nx][ny] = true
                }
            }
        }
    }
}

fun bfs2(si: Int, sj: Int, graph: Array<CharArray>, node: Char) {
    val q = LinkedList<Pair<Int, Int>>()
    q.offer(si to sj)
    visited[si][sj] = true

    while (q.isNotEmpty()) {
        val (ci, cj) = q.poll()

        for (i in 0 until 4) {
            val nx = ci + dx[i]
            val ny = cj + dy[i]

            if (nx in graph.indices && ny in graph[0].indices && !visited[nx][ny]) {
                if ((node == 'R'  &&graph[nx][ny] == 'G') || (node == 'G'  &&graph[nx][ny] == 'R') || node == graph[nx][ny]) {
                    q.offer(nx to ny)
                    visited[nx][ny] = true
                }
            }
        }
    }
}