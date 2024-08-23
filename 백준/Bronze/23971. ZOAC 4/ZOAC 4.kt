import kotlin.math.ceil

val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (h, w, n, m) = br.readLine().split(" ").map { it.toInt() }

    val a = ceil((h.toDouble()/(n+1).toDouble()))
    val b = ceil((w.toDouble()/(m+1).toDouble()))

    print((a*b).toInt())
    close()
}