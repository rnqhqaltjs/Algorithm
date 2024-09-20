import kotlin.math.max

val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val n = br.readLine().toInt()
    val sequence = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    val dp = IntArray(n + 1) { 1 }
    var result = 0

    for (i in 0 until n) {
        for (j in 0 until i) {
            if (sequence[i] < sequence[j]) {
                dp[i] = max(dp[i], dp[j] + 1)
            }
        }
        result = max(result, dp[i])
    }

    println(result)
    close()
}