import java.util.LinkedList

val br = System.`in`.bufferedReader()

val dx = arrayOf(-2, -1, -2, -1, 2, 1, 2, 1)
val dy = arrayOf(-1, -2, 1, 2, -1, -2, 1, 2)

fun main() = with(System.out.bufferedWriter()) {
    val t = br.readLine().toInt()

    repeat(t) {
        val n = br.readLine().toInt()
        val (x, y) = br.readLine().split(" ").map { it.toInt() }
        val (goalX, goalY) = br.readLine().split(" ").map { it.toInt() }

        val graph = Array(n) { IntArray(n) }
        val visited = Array(n) { BooleanArray(n) { false } }

        val answer = bfs(x, y, graph, visited, goalX, goalY)

        write("$answer\n")
    }
    close()
}

fun bfs(si: Int, sj: Int, graph: Array<IntArray>, v: Array<BooleanArray>, goalX: Int, goalY: Int): Int {
    val q = LinkedList<Triple<Int, Int, Int>>()
    q.offer(Triple(si, sj, 0))
    v[si][sj] = true

    while (q.isNotEmpty()) {
        val (ci, cj, count) = q.poll()

        if(ci == goalX && cj == goalY) {
            return count
        }

        for (i in 0 until 8) {
            val nx = ci + dx[i]
            val ny = cj + dy[i]

            if (nx in graph.indices && ny in graph[0].indices && !v[nx][ny]) {
                q.offer(Triple(nx, ny, count + 1))
                v[nx][ny] = true
            }
        }
    }
    return 0
}