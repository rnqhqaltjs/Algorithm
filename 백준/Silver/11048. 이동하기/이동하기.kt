val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (r, c) = br.readLine().split(" ").map { it.toInt() }

    val graph = Array(r) { br.readLine().split(" ").map { it.toInt() } }
    val dp = Array(r + 1) { IntArray(c + 1) { 0 } }

    for (i in 1..r) {
        for (j in 1..c) {
            dp[i][j] = maxOf(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + graph[i - 1][j - 1]
        }
    }

    write("${dp[r][c]}")
    close()
}