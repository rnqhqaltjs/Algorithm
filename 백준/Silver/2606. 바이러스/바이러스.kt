val br = System.`in`.bufferedReader()
var count = 0

fun main() = with(System.out.bufferedWriter()) {

    val n = br.readLine().toInt()
    val m = br.readLine().toInt()

    val graph = Array(n + 1) { mutableListOf<Int>() }

    val visited = BooleanArray(n + 1)

    for (i in 0 until m) {
        val (x, y) = br.readLine().split(" ").map { it.toInt() }

        graph[x].add(y)
        graph[y].add(x)
    }

    for (i in 1..n) {
        graph[i].sort()
    }

    dfs(1, graph, visited)

    write(count.toString())
    close()
}
fun dfs(c: Int, graph: Array<MutableList<Int>>, v: BooleanArray) {
    v[c] = true

    for (i in graph[c]) {
        if (!v[i]) {
            count ++
            dfs(i, graph, v)
        }
    }
}