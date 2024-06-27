import java.util.LinkedList

val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {

    val (n, m, v) = br.readLine().split(" ").map { it.toInt() }
    val graph = Array(n + 1) { mutableListOf<Int>() }

    var visited = BooleanArray(n + 1)

    for (i in 0 until m) {
        val (x, y) = br.readLine().split(" ").map { it.toInt() }

        graph[x].add(y)
        graph[y].add(x)
    }

    for (i in 1..n) {
        graph[i].sort()
    }


    dfs(v, graph, visited)
    println()

    visited = BooleanArray(n + 1)
    bfs(v, graph, visited)

    close()
}

fun dfs(c: Int, graph: Array<MutableList<Int>>, v: BooleanArray) {
    print("$c ")
    v[c] = true

    for (i in graph[c]) {
        if (!v[i]) {
            dfs(i, graph, v)
        }
    }
}

fun bfs(s: Int, graph: Array<MutableList<Int>>, v: BooleanArray) {
    val q = LinkedList<Int>()
    q.add(s)
    v[s] = true

    while (q.isNotEmpty()) {
        val c = q.poll()
        print("$c ")

        for (i in graph[c]) {
            if (!v[i]) {
                q.add(i)
                v[i] = true
            }
        }
    }
}