val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val dp = Array(41) { IntArray(2) }

    dp[0][0] = 1
    dp[0][1] = 0
    dp[1][0] = 0
    dp[1][1] = 1

    val t = br.readLine().toInt()

    repeat(t) {
        val n = br.readLine().toInt()

        for (i in 2 until 41) {
            dp[i][0] = dp[i - 1][0] + dp[i - 2][0]
            dp[i][1] = dp[i - 1][1] + dp[i - 2][1]
        }

        write("${dp[n][0]} ${dp[n][1]}\n")
    }

    close()
}
