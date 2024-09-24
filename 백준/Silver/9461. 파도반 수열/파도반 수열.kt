val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val t = br.readLine().toInt()

    repeat(t) {
        val n = br.readLine().toInt()
        val dp = LongArray(101)

        dp[0] = 1
        dp[1] = 1
        dp[2] = 1

        for (i in 3..100) {
            dp[i] = dp[i - 3] + dp[i - 2]
        }

        write("${dp[n - 1]}\n")
    }
    close()
}