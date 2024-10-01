val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (n, l) = br.readLine().split(" ").map { it.toInt() }
    val array = br.readLine().split(" ").map { it.toInt() }.toIntArray()

    array.sort()

    var start = array[0]
    var count = 0

    for (i in 1 until array.size) {
        if (l <= array[i] - start) {
            count++
            start = array[i]
        }
    }

    write("${count + 1}")
    close()
}