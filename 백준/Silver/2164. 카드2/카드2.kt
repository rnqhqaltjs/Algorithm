import java.util.LinkedList
import java.util.Queue

val br = System.`in`.bufferedReader()

fun main() =with(System.out.bufferedWriter()){

    val n = br.readLine().toInt()
    val queue : Queue<Int> = LinkedList()

    for(i in 1 .. n) {
        queue.add(i)
    }

    while(queue.size != 1) {
        queue.poll()
        queue.add(queue.poll())
    }

    write(queue.element().toString())
    close()
}