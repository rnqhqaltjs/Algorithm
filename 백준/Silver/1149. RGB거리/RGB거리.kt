import kotlin.math.min

val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val n = br.readLine().toInt()
    val dp = Array(n) { IntArray(3) }
    val array = Array(n) { IntArray(3) }
    
    repeat(n) {
        array[it] = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    dp[0][0] = array[0][0]
    dp[0][1] = array[0][1]
    dp[0][2] = array[0][2]

    for (i in 1 until n) {
        dp[i][0] = min(dp[i-1][1], dp[i - 1][2]) + array[i][0]
        dp[i][1] = min(dp[i-1][0], dp[i - 1][2]) + array[i][1]
        dp[i][2] = min(dp[i-1][0], dp[i - 1][1]) + array[i][2]
    }

    var min = Int.MAX_VALUE
    for (i in 0 until 3) {
        min = min(dp[n-1][i], min)
    }

    write("$min")
    close()
}