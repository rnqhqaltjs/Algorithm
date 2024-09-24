import kotlin.math.max

val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val n = br.readLine().toInt()
    val dp = IntArray(n + 1) { 1 }
    val line = IntArray(n+1)
    repeat(n) {
        line[it] = br.readLine().toInt()
    }

    for (i in 0 until n) {
        for (j in 0 until i) {
            if (line[i] > line[j]) {
                dp[i] = max(dp[i], dp[j] + 1)
            }
        }
    }

    write("${n - dp.max()}")
    close()
}