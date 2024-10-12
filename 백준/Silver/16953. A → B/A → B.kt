import kotlin.math.min

val br = System.`in`.bufferedReader()

var answer = Long.MAX_VALUE
fun main() = with(System.out.bufferedWriter()) {
    val (a, b) = br.readLine().split(" ").map { it.toLong() }

    dfs(a, b, 1)

    if(answer == Long.MAX_VALUE) {
        write("-1")
    } else {
        write("$answer")
    }
    close()
}

fun dfs(c: Long, end: Long, count: Long) {
    if (c == end) {
        answer = min(count, answer)
        return
    }

    if (c > end) {
        return
    }
    dfs(c * 2, end, count + 1)
    dfs(c * 10 + 1, end, count + 1)
}