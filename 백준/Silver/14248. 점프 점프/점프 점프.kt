import java.util.StringTokenizer

val br = System.`in`.bufferedReader()

var count = 0
fun main() = with(System.out.bufferedWriter()) {
    var tk = StringTokenizer(br.readLine())
    val n = tk.nextToken().toInt()
    tk = StringTokenizer(br.readLine())
    val graph = IntArray(n) { tk.nextToken().toInt() }
    tk = StringTokenizer(br.readLine())
    val s = tk.nextToken().toInt()
    val visited = BooleanArray(n + 1)

    dfs(s - 1   , graph, visited)

    write("$count\n")

    close()
}

fun dfs(s: Int, graph: IntArray, v: BooleanArray) {
    v[s] = true
    count++

    val left = s - graph[s]
    val right = s + graph[s]
    if (left in graph.indices && !v[left]) {
        dfs(left, graph, v)
    }

    if (right in graph.indices && !v[right]) {
        dfs(right, graph, v)
    }
}