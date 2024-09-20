val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val t = br.readLine().toInt()

    repeat(t) {
        val n = br.readLine().toInt()
        val dp = IntArray(12) { 0 }

        dp[0] = 0
        dp[1] = 1
        dp[2] = 2
        dp[3] = 4

        for (i in 4..11) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3]
        }

        println(dp[n])
    }
    close()
}