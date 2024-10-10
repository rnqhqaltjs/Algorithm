import java.util.PriorityQueue

val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {

    val t = br.readLine().toInt()
    val pq = PriorityQueue<Int>(compareBy({-it}))

    repeat(t) {
        val n = br.readLine().toInt()

        if(n == 0) {
            if(pq.isNotEmpty()) {
                write("${pq.poll()}\n")
            } else {
                write("0\n")
            }
        } else {
            pq.offer(n)
        }
    }

    close()
}
