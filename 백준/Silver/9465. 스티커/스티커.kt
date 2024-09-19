import kotlin.math.max

val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val t = br.readLine().toInt()

    repeat(t) {
        val n = br.readLine().toInt()

        val picture = Array(2) { IntArray(n + 1) { 0 } }

        for (i in 0 until 2) {
            val line = br.readLine().split(" ").map { it.toInt() }
            for (j in 1..n) {
                picture[i][j] = line[j - 1]
            }
        }

        val dp = Array(2) { IntArray(n + 1) }

        dp[0][0] = picture[0][0]
        dp[1][0] = picture[1][0]
        dp[0][1] = picture[0][1]
        dp[1][1] = picture[1][1]

        for (i in 2..n) {
            dp[0][i] = max(dp[1][i - 1], dp[1][i - 2]) + picture[0][i]
            dp[1][i] = max(dp[0][i - 1], dp[0][i - 2]) + picture[1][i]
        }

        write("${max(dp[0][n], dp[1][n])}\n")

    }

    close()
}