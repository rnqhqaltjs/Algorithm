val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val n = br.readLine().toInt()
    val array = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    val (b, c) = br.readLine().split(" ").map { it.toLong() }

    var count: Long = 0
    for (i in array) {
        val remain = i - b
        count++

        if (remain > 0) {
            if (remain % c == 0L) {
                count += remain / c
            } else {
                count += remain / c + 1
            }
        }
    }

    write("$count")
    close()
}