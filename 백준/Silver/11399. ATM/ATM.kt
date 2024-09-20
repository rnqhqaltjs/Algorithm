val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val n = br.readLine().toInt()
    val line = br.readLine().split(" ").map { it.toInt() }.toIntArray()

    line.sort()

    var sum = 0
    val array = mutableListOf<Int>()
    for (i in line.indices) {
        sum += line[i]

        array.add(sum)
    }

    write("${array.sum()}")
    close()
}