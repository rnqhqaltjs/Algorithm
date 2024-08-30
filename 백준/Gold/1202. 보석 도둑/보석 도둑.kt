import java.util.Collections
import java.util.PriorityQueue

val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    val jewel = Array(n) { Pair(0, 0) }
    val bag = mutableListOf<Int>()
    val priorityQueue = PriorityQueue<Int>(Collections.reverseOrder())

    repeat(n) {
        val (m, v) = br.readLine().split(" ").map { it.toInt() }
        jewel[it] = Pair(m, v)
    }

    repeat(k) {
        val c  = br.readLine().toInt()
        bag.add(c)
    }

    jewel.sortBy { it.first }
    bag.sort()

    var idx = 0
    var sum = 0L

    for(i in 0 until k) {
        while(n>idx && bag[i] >= jewel[idx].first) {
            priorityQueue.offer(jewel[idx].second)
            idx++
        }

        if(priorityQueue.isNotEmpty()) {
            sum += priorityQueue.poll()
        }
    }

    write("$sum")

    close()
}