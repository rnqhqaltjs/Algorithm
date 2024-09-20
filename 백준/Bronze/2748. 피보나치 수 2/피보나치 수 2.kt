val br = System.`in`.bufferedReader()
lateinit var dp: LongArray

fun main() = with(System.out.bufferedWriter()) {
    val n = br.readLine().toInt()
    dp = LongArray(100001)

    println(fibo(n))
    close()
}

fun fibo(num: Int): Long {
    dp[0] = 0
    dp[1] = 1

    for (i in 2..num) {
        dp[i] = dp[i - 1] + dp[i - 2]
    }

    return dp[num]
}