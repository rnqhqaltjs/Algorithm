import kotlin.math.max

val br = System.`in`.bufferedReader()

val dX = arrayOf(-1, 0, 1, 0)
val dY = arrayOf(0, 1, 0, -1)
var flag = 1

fun main() = with(System.out.bufferedWriter()) {
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val graph = Array(n + 1) { mutableListOf<Int>() }

    for (i in 0 until m) {
        val (x, y) = br.readLine().split(" ").map { it.toInt() }
        graph[y].add(x)
    }

    val hackCount = IntArray(n + 1)
    var maxCount = 0

    for (i in 1..n) {
        val visited = BooleanArray(n + 1)
        val count = dfs(i, graph, visited)
        hackCount[i] = count
        maxCount = max(maxCount, count)
    }

    for (i in 1..n) {
        if (hackCount[i] == maxCount) {
            write("$i ")
        }
    }
    close()
}

fun dfs(c: Int, graph: Array<MutableList<Int>>, v: BooleanArray): Int {
    v[c] = true
    var count = 1

    for (i in graph[c]) {
        if (!v[i]) {
            count += dfs(i, graph, v)
        }
    }

    return count
}