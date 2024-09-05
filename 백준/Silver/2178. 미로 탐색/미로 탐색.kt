import java.util.LinkedList

val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {

    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val graph = Array(n) { IntArray(m) {0} }
    val visited = Array(n) { IntArray(m) {0} }

    for (i in 0 until n) {
        graph[i] = br.readLine().map { it - '0' }.toIntArray()
    }

    bfs(0, 0, graph, visited)

    close()
}

fun bfs(x: Int, y: Int, graph: Array<IntArray>, v: Array<IntArray>) {
    val q = LinkedList<Pair<Int, Int>>()
    q.add(Pair(x, y))
    v[x][y] = 1

    while (q.isNotEmpty()) {
        val (a, b) = q.poll()

        if (a == graph.size - 1 && b == graph[0].size - 1) {
            print("${v[a][b]}")
            return
        }
        if(a- 1 >= 0 && graph[a - 1][b] == 1 && v[a - 1][b] == 0) {
            q.add(Pair(a - 1, b))
            v[a - 1][b] = v[a][b] + 1
        }

        if(a+1 < graph.size && graph[a + 1][b] == 1 && v[a + 1][b] == 0) {
            q.add(Pair(a + 1, b))
            v[a + 1][b] = v[a][b] + 1
        }

        if(b - 1 >= 0 && graph[a][b - 1] == 1 && v[a][b - 1] == 0) {
            q.add(Pair(a, b - 1))
            v[a][b - 1] = v[a][b] + 1
        }

        if(b + 1 < graph[0].size && graph[a][b + 1] == 1 && v[a][b + 1] == 0) {
            q.add(Pair(a, b + 1))
            v[a][b + 1] = v[a][b] + 1
        }
    }
}