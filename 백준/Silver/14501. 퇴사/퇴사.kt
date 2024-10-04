import kotlin.math.max

val br = System.`in`.bufferedReader()

var n = 0
var answer = 0
lateinit var meet: Array<IntArray>
fun main() = with(System.out.bufferedWriter()) {
    n = br.readLine().toInt()
    meet = Array(n) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }


    dfs(0, 0)
    write("$answer")
    close()
}

fun dfs(start: Int, revenue: Int) {
    if (start >= n) {
        answer = max(answer, revenue)
        return
    }
    val nx = start + meet[start][0]
    if (nx <= n) {
        dfs(nx, revenue + meet[start][1])
    }
    dfs(start + 1, revenue)
}