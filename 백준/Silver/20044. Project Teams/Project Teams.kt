import kotlin.math.min

val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val n = br.readLine().toInt()
    val student = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    var min = Int.MAX_VALUE

    student.sortDescending()

    for (i in 0 until n) {
        val sum = student[i] + student[n * 2 - 1 - i]

        min = min(min, sum)
    }

    write("$min")
    close()
}