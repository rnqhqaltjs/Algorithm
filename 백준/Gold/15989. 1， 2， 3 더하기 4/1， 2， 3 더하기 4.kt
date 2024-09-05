val br = System.`in`.bufferedReader()

fun main() =with(System.out.bufferedWriter()){
    val t = br.readLine().toInt()
    val dp = IntArray(10001) { 1 }

    for(i in 2 until 10001) {
        dp[i] += dp[i-2]
    }

    for(i in 3 until 10001) {
        dp[i] += dp[i-3]
    }

    repeat(t) {
        val n = br.readLine().toInt()
        write("${dp[n]}\n")
    }
    close()
}