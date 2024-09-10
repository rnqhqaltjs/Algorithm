import kotlin.math.max

val br = System.`in`.bufferedReader()
var answer = 0

fun main() = with(System.out.bufferedWriter()) {
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val graph = Array(n) { CharArray(m) }
    val visited = BooleanArray(128)


    for (i in 0 until n) {
        val line = br.readLine()
        for (j in 0 until m) {
            graph[i][j] = line[j]
        }
    }

    visited[graph[0][0].code] = true
    dfs(0, 0, 1, graph, visited)

    write("$answer")
    close()
}

fun dfs(cX: Int, cY: Int, count:Int, graph: Array<CharArray>, v: BooleanArray) {
    val directions = listOf(-1 to 0, 1 to 0, 0 to -1, 0 to 1)
    answer = max(count, answer)

    for((dx, dy) in directions) {
        val nx = cX + dx
        val ny = cY + dy

        if(nx in graph.indices && ny in graph[0].indices && !v[graph[nx][ny].code]) {
            v[graph[nx][ny].code] = true
            dfs(nx, ny, count+1, graph, v)
            v[graph[nx][ny].code] = false
        }
    }
}