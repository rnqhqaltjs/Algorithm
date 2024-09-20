val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val n = br.readLine().toInt()
    val a = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    val b = br.readLine().split(" ").map { it.toInt() }.toIntArray()

    a.sort()
    b.sortDescending()

    var sum = 0
    for (i in a.indices) {
        sum += a[i] * b[i]
    }

    write("$sum")
    close()
}