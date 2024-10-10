import java.util.PriorityQueue
import kotlin.math.abs

val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {

    val t = br.readLine().toInt()

    val pq = PriorityQueue<Pair<Int,Int>>(compareBy({ it.second }, { it.first }))

    repeat(t) {
        val n = br.readLine().toInt()

        if (n == 0) {
            if (pq.isNotEmpty()) {
                write("${pq.poll().first}\n")
            } else {
                write("0\n")
            }
        } else {
            pq.offer(n to abs(n))
        }
    }

    close()
}
