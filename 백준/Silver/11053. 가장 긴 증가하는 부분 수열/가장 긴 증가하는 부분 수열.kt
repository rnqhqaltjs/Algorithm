import kotlin.math.max

val br = System.`in`.bufferedReader()

fun main() =with(System.out.bufferedWriter()){

    val n = br.readLine().toInt()
    val m = br.readLine().split(' ').map { it.toInt() }
    val dp = IntArray(n){1}

    for(i in 0 until n) {
        for(j in 0 until i) {
            if(m[i]>m[j]) {
                dp[i] = max(dp[i], dp[j]+1)
            }
        }
    }

    write(dp.max().toString())
    close()
}




