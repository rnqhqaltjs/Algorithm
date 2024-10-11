val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (n, m) = br.readLine().split(" ").map { it.toLong() }
    val array = br.readLine().split(" ").map { it.toLong() }.toLongArray()

    array.sort()

    var first: Long = 0
    var last: Long = array[n.toInt() - 1]
    var max: Long = 0

    while (first <= last) {
        val mid: Long = (first + last) / 2
        var sum: Long = 0

        for (i in array) {
            if (i - mid > 0) {
                sum += i - mid
            }
        }

        if (sum >= m) {
            first = mid + 1
            max = mid
        } else {
            last = mid - 1
        }
    }

    write("$max")
    close()
}
