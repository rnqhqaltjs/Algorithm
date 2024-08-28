import java.util.PriorityQueue

val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val n = br.readLine().toInt()
    val priorityQueue = PriorityQueue<Int>()


    for(i in 0 until n) {
        val numbers = br.readLine().split(" ").map { it.toInt() }

        for(number in numbers) {
            priorityQueue.offer(number)

            if(priorityQueue.size>n) {
                priorityQueue.poll()
            }
        }
    }

    write("${priorityQueue.poll()}")
    close()
}
