val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val graph = Array(n + 1) { mutableListOf<Int>() }
    val visited = BooleanArray(n + 1)
    var count = 0

    repeat(m) {
        val (x, y) = br.readLine().split(" ").map { it.toInt() }

        graph[x].add(y)
        graph[y].add(x)
    }

    for(i in 1..n) {
        if(!visited[i]) {
            dfs(i, graph, visited)
            count++
        }
    }

    write("$count")
    close()
}

fun dfs(c: Int, graph: Array<MutableList<Int>>, v: BooleanArray) {
    v[c] = true

    for(i in graph[c]) {
        if(!v[i]) {
            dfs(i, graph, v)
        }
    }
}