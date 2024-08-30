import kotlin.math.min

val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val space = Array(n) { IntArray(m) }
    val dp = Array(n) { Array(m) { IntArray(3) { Int.MAX_VALUE } } }

    for(i in 0 until n) {
        space[i] = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    for(j in 0 until m) {
        dp[0][j][0] = space[0][j]
        dp[0][j][1] = space[0][j]
        dp[0][j][2] = space[0][j]
    }

    for(i in 1 until n) {
        for(j in 0 until m) {
            when (j) {
                0 -> {
                    dp[i][j][0] = min(dp[i-1][j+1][1],dp[i-1][j+1][2]) + space[i][j]
                    dp[i][j][1] = dp[i-1][j][0] + space[i][j]
                }
                m-1 -> {
                    dp[i][j][1] = dp[i-1][j][2] + space[i][j]
                    dp[i][j][2] = min(dp[i-1][j-1][0], dp[i-1][j-1][1]) +space[i][j]
                }
                else -> {
                    dp[i][j][0] = min(dp[i-1][j+1][1],dp[i-1][j+1][2]) + space[i][j]
                    dp[i][j][1] = min(dp[i-1][j][0], dp[i-1][j][2]) + space[i][j]
                    dp[i][j][2] = min(dp[i-1][j-1][0], dp[i-1][j-1][1]) +space[i][j]
                }
            }
        }
    }

    var min = Int.MAX_VALUE

    for(j in 0 until m) {
        for(i in 0 until 3) {
            min = min(dp[n-1][j][i], min)
        }
    }

    write("$min")
    close()
}