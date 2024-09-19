import kotlin.math.max

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val point = IntArray(n + 1) { 0 }

    for (i in 1..n) {
        point[i] = readLine().toInt()
    }

    if (n == 1) {
        println(point[n])
        return
    }

    val dp = IntArray(n + 1)

    dp[1] = point[1]
    dp[2] = point[1] + point[2]

    for (i in 3 .. n) {
        dp[i] = max(point[i] + dp[i - 2], point[i] + point[i - 1] + dp[i - 3])
    }

    println(dp[n])
}
