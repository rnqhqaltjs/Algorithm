import java.util.LinkedList

val br = System.`in`.bufferedReader()

val dx = arrayOf(-1, 0, 1, 0)
val dy = arrayOf(0, 1, 0, -1)

fun main() = with(System.out.bufferedWriter()) {
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val graph = Array(n) { br.readLine().map { it - '0' }.toIntArray() }
    val visited = Array(n) { Array(m) { BooleanArray(2) { false } } }

    write("${bfs(0, 0, graph, visited)}")

    close()
}

data class Node(val row: Int, val col: Int, val distance: Int, val wall: Int)

fun bfs(si: Int, sj: Int, graph: Array<IntArray>, v: Array<Array<BooleanArray>>): Int {
    val q = LinkedList<Node>()
    q.offer(Node(si, sj, 1, 0))
    v[si][sj][0] = true

    while (q.isNotEmpty()) {
        val (ci, cj, distance, wall) = q.poll()

        if (ci == graph.size - 1 && cj == graph[0].size - 1) return distance

        for (i in 0 until 4) {
            val nx = ci + dx[i]
            val ny = cj + dy[i]

            if (nx in graph.indices && ny in graph[0].indices) {
                if (graph[nx][ny] == 1 && !v[nx][ny][1] && wall == 0) {
                    q.add(Node(nx, ny, distance + 1, 1))
                    v[nx][ny][1] = true
                }

                if (graph[nx][ny] == 0 && !v[nx][ny][wall]) {
                    q.add(Node(nx, ny, distance + 1, wall))
                    v[nx][ny][wall] = true
                }
            }
        }
    }

    return -1
}