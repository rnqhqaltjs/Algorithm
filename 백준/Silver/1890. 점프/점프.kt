val br = System.`in`.bufferedReader()

val dx = arrayOf(0, 1)
val dy = arrayOf(1, 0)

fun main() = with(System.out.bufferedWriter()) {
    val n = br.readLine().toInt()
    val board = Array(n) { IntArray(n) }
    val dp = Array(n) { LongArray(n) }


    repeat(n) {
        board[it] = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    dp[0][0] = 1L

    for (i in 0 until n) {
        for (j in 0 until n) {
            if (board[i][j] == 0 || (i == n - 1 && j == n - 1)) continue

            val ni = i + board[i][j]
            if (ni in 0 until n) {
                dp[ni][j] += dp[i][j]
            }

            val nj = j + board[i][j]
            if (nj in 0 until n) {
                dp[i][nj] += dp[i][j]
            }
        }
    }

    write("${dp[n - 1][n - 1]}")
    close()
}