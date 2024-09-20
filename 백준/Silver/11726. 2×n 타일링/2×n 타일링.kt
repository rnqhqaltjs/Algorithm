val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val n = br.readLine().toInt()
    val dp = IntArray(n+1) { 0 }

    if(n==1) {
        dp[1] = 1
    } else {
        dp[1] = 1
        dp[2] = 2
    }

    for (i in 3..n) {
        dp[i] = (dp[i - 1] + dp[i - 2]) % 10007

    }

    println(dp[n])
    close()
}