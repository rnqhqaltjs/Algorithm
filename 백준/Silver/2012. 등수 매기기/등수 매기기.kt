import kotlin.math.abs

val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val t = br.readLine().toInt()
    val rank = mutableListOf<Long>()

    repeat(t) {
        val n = br.readLine().toLong()
        rank.add(n)
    }

    rank.sort()

    var sum = 0L
    for(i in 0 until t) {
        sum+= abs(rank[i]-(i+1))
    }
    write("$sum")
    close()
}