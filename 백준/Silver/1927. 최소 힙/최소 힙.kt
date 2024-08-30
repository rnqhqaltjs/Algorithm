import java.util.PriorityQueue

val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val n = br.readLine().toInt()
    val pq = PriorityQueue<Int>()

    for(i in 0 until n) {
        val x = br.readLine().toInt()

        if(x == 0) {
            if(pq.isEmpty()) {
                write("0\n")
            } else {
                write("${pq.poll()}\n")
            }
        } else {
            pq.offer(x)
        }
    }
    close()
}