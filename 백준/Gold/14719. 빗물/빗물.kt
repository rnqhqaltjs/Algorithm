import kotlin.math.max
import kotlin.math.min

val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val array = br.readLine().split(" ").map { it.toInt() }
    var count = 0


    for(i in 1 until m -1) {
        var left = 0
        var right = 0

        for(j in 0 until i) {
            left = max(left, array[j])
        }

        for(j in m-1 downTo i+1) {
            right = max(right, array[j])
        }
        val current = min(left, right) - array[i]
        if(current>0) {
            count += current
        }
    }
    write("$count")
    close()
}