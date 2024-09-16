import java.util.LinkedList
import java.util.Queue

val br = System.`in`.bufferedReader()

val dx = arrayOf(1, 0, 0, -1)
val dy = arrayOf(0, 1, -1, 0)

var count = 0
val countList = mutableListOf<Int>()

fun main() = with(System.out.bufferedWriter()) {
    val (m, n, k) = br.readLine().split(" ").map { it.toInt() }
    val graph = Array(m) { IntArray(n) { 0 } }
    val visited = Array(m) { BooleanArray(n) }

    repeat(k) {
        val line = br.readLine().split(" ").map { it.toInt() }

        for (i in line[1] until line[3]) {
            for (j in line[0] until line[2]) {
                graph[i][j] = 1
            }
        }
    }

    for (i in 0 until m) {
        for (j in 0 until n) {
            if (graph[i][j] == 0 && !visited[i][j]) {
                bfs(i, j, graph, visited)
            }
        }
    }

    countList.sort()

    write("${countList.size}\n")
    for(i in countList) {
        write("$i\n")
    }
    close()
}

fun bfs(ci: Int, cj: Int, graph: Array<IntArray>, v: Array<BooleanArray>) {
    val q: Queue<Pair<Int, Int>> = LinkedList()
    q.add(Pair(ci, cj))
    v[ci][cj] = true
    count = 1

    while (q.isNotEmpty()) {
        val (cX, cY) = q.poll()

        for (i in 0 until 4) {
            val nX = cX + dx[i]
            val nY = cY + dy[i]

            if (nX in graph.indices && nY in graph[0].indices && !v[nX][nY] && graph[nX][nY] == 0) {
                q.add(Pair(nX, nY))
                v[nX][nY] = true
                count++
            }
        }
    }
    countList.add(count)
}