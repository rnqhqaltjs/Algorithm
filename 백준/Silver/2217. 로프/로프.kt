import kotlin.math.max

val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val t = br.readLine().toInt()
    val array = mutableListOf<Int>()
    var max = 0

    repeat(t) {
        val n = br.readLine().toInt()
        array.add(n)
    }

    array.sortDescending()


    for(i in array.indices) {
        val current = array[i] * (i+1)

        max = max(current, max)
    }

    write("$max")
    close()
}