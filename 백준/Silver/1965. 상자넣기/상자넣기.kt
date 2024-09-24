import kotlin.math.max

val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val n = br.readLine().toInt()
    val dp = IntArray(n + 1) { 1 }
    val box = br.readLine().split(" ").map { it.toInt() }.toIntArray()

    for (i in 0 until n) {
        for (j in 0 until i) {
            if (box[i] > box[j]) {
                dp[i] = max(dp[i], dp[j] + 1)
            }
        }
    }

    write("${dp.max()}")
    close()
}