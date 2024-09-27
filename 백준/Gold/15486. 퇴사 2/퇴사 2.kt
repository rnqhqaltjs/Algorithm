import kotlin.math.max

val br = System.`in`.bufferedReader()

fun main() =with(System.out.bufferedWriter()){
    val n = br.readLine().toInt()
    val counsel = Array(n) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }
    val dp = IntArray(n+1)

    for(i in counsel.indices) {
        val nx = i+ counsel[i][0]
        if(i>0) dp[i] = max(dp[i], dp[i-1])
        if(nx<=n) {
            dp[nx] = max(dp[nx], dp[i] + counsel[i][1])
        }
    }

    write(dp.max().toString())
    close()
}

