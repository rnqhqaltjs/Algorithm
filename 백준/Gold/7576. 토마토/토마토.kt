import java.util.LinkedList

val br = System.`in`.bufferedReader()
val q = LinkedList<Pair<Int,Int>>()

fun main() = with(System.out.bufferedWriter()) {
    val (m, n) = br.readLine().split(" ").map { it.toInt() }
    val graph = Array(n) { IntArray(m) }
    var max = 0

    for (i in 0 until n) {
        val line = br.readLine().split(" ").map { it.toInt() }
        for (j in 0 until m) {
            graph[i][j] = line[j]
        }
    }

    for(i in 0 until n) {
        for(j in 0 until m) {
            if(graph[i][j] == 1) {
                q.add(Pair(i , j))
            }
        }
    }

    bfs(graph)

    for(i in 0 until n) {
        for(j in 0 until m) {
            if(graph[i][j] == 0) {
                write("-1")
                close()
                return
            }
            if(graph[i][j] > max) {
                max = graph[i][j]
            }
        }
    }

    write("${max-1}")
    close()
}

fun bfs(graph: Array<IntArray>) {
    val directions = listOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1)

    while (q.isNotEmpty()) {
        val (cX, cY) = q.poll()

        for ((dx, dy) in directions) {
            val nx = cX + dx
            val ny = cY + dy

            if (nx in graph.indices && ny in graph[0].indices && graph[nx][ny] == 0) {
                graph[nx][ny] = graph[cX][cY] + 1
                q.add(Pair(nx, ny))
            }
        }
    }
}