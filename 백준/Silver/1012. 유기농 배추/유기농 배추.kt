import java.util.LinkedList

val br = System.`in`.bufferedReader()

val dx = arrayOf(-1, 0, 1, 0)
val dy = arrayOf(0, 1, 0, -1)

fun main() = with(System.out.bufferedWriter()) {
    val t = br.readLine().toInt()

    repeat(t) {
        val (m, n, k) = br.readLine().split(" ").map { it.toInt() }
        val graph = Array(n) { IntArray(m) { 0 } }
        val visited = Array(n) { BooleanArray(m) }

        repeat(k) {
            val (x, y) = br.readLine().split(" ").map { it.toInt() }
            graph[y][x] = 1
        }

        var count = 0
        for (i in 0 until n) {
            for (j in 0 until m) {
                if (graph[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j, graph, visited)
                    count++
                }
            }
        }

        write("$count\n")
    }

    close()
}

fun bfs(si: Int, sj: Int, graph: Array<IntArray>, v: Array<BooleanArray>) {
    val q = LinkedList<Pair<Int, Int>>()
    q.add(si to sj)
    v[si][sj] = true

    while (q.isNotEmpty()) {
        val (ci, cj) = q.poll()

        for (i in 0 until 4) {
            val nx = ci + dx[i]
            val ny = cj + dy[i]

            if (nx in graph.indices && ny in graph[0].indices && !v[nx][ny] && graph[nx][ny] == 1) {
                q.add(nx to ny)
                v[nx][ny] = true
            }
        }
    }
}