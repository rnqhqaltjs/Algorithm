import kotlin.math.max

val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (n, d, k, c) = br.readLine().split(" ").map { it.toInt() }
    val sushiList = IntArray(n) { br.readLine().toInt() }
    val sushiSeq = mutableListOf<Int>()
    var max = 0

    for(i in 0 until k) {
        sushiSeq.add(sushiList[i])
    }

    for(i in 0 until n) {
        sushiSeq.remove(sushiList[i])
        sushiSeq.add(sushiList[(i + k) % n])

        val currentSet = sushiSeq.toMutableSet()
        currentSet.add(c)
        max = max(currentSet.size, max)
    }

    write("$max")
    close()
}