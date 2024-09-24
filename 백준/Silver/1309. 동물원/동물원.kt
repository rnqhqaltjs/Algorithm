val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val n = br.readLine().toInt()
    val dp = IntArray(n + 1)

    dp[0] = 3
    dp[1] = 7

    for (i in 2..n) {
        dp[i] = (dp[i - 1] * 2 + dp[i - 2]) % 9901
    }

    write("${dp[n-1]}")
    close()
}