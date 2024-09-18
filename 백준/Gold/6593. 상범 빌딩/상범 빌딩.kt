import java.util.LinkedList

val br = System.`in`.bufferedReader()

val dx = arrayOf(-1, 0, 1, 0, 0, 0)
val dy = arrayOf(0, 1, 0, -1, 0, 0)
val dl = arrayOf(0, 0, 0, 0, 1, -1)

fun main() = with(System.out.bufferedWriter()) {
    while (true) {
        val (l, r, c) = br.readLine().split(" ").map { it.toInt() }
        val graph = Array(l) { Array(r) { CharArray(c) } }
        val visited = Array(l) { Array(r) { BooleanArray(c) } }
        if (l == 0 && r == 0 && c == 0) {
            break
        }

        for (i in 0 until l) {
            for (j in 0 until r) {
                val line = br.readLine()

                for (k in 0 until c) {
                    graph[i][j][k] = line[k]
                }
            }
            br.readLine()
        }

        var answer = -1
        for (i in 0 until l) {
            for (j in 0 until r) {
                for (k in 0 until c) {
                    if (graph[i][j][k] == 'S') {
                        answer = bfs(i, j, k, graph, visited)
                    }
                }
            }
        }

        if (answer == -1) {
            write("Trapped!\n")
        } else {
            write("Escaped in $answer minute(s).\n")
        }
    }
    close()
}

fun bfs(
    sl: Int,
    sx: Int,
    sy: Int,
    graph: Array<Array<CharArray>>,
    v: Array<Array<BooleanArray>>,
): Int {
    val q = LinkedList<Pair<Triple<Int, Int, Int>, Int>>()
    q.offer(Pair(Triple(sl, sx, sy), 0))
    v[sl][sx][sy] = true

    while (q.isNotEmpty()) {
        val (current, count) = q.poll()
        val (cl, cx, cy) = current

        if (graph[cl][cx][cy] == 'E') {
            return count
        }

        for (i in 0 until 6) {
            val nl = cl + dl[i]
            val nx = cx + dx[i]
            val ny = cy + dy[i]

            if (nl in graph.indices && nx in graph[0].indices && ny in graph[0][0].indices) {
                if (!v[nl][nx][ny] && graph[nl][nx][ny] != '#') {
                    q.offer(Pair(Triple(nl, nx, ny), count+1))
                    v[nl][nx][ny] = true
                }
            }
        }
    }

    return -1
}