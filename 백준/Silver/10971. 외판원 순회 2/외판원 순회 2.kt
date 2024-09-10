import kotlin.math.min

val br = System.`in`.bufferedReader()
var min  = Long.MAX_VALUE

fun main() = with(System.out.bufferedWriter()) {
    val n = br.readLine().toInt()
    val graph = Array(n) { IntArray(n) }
    val visited = BooleanArray(n)


    for (i in 0 until n) {
        val line = br.readLine().split(" ").map { it.toInt() }
        for (j in 0 until n) {
            graph[i][j] = line[j]
        }
    }

    for(i in 0 until n) {
        if(!visited[i]) {
            visited[i] = true
            dfs(i, i, 1, graph, visited, 0)
            visited[i] = false
        }
    }

    write("$min")
    close()
}

fun dfs(s: Int, c: Int, count:Int, graph: Array<IntArray>, v: BooleanArray, weight: Long) {
    if(count == graph.size) {
        if(graph[c][s] != 0) {
            min = min(min, weight + graph[c][s])
        }
        return
    }

    for(i in graph.indices) {
        if(!v[i] && graph[c][i] !=0) {
            v[i] = true
            dfs(s, i, count + 1, graph, v, weight + graph[c][i])
            v[i] = false
        }
    }
}