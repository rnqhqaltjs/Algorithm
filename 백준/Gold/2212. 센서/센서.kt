val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val n = br.readLine().toInt()
    val k = br.readLine().toInt()
    val center = br.readLine().split(" ").map { it.toInt() }.toIntArray()

    center.sort()

    val distance = mutableListOf<Int>()
    for (i in 1 until center.size) {
        distance.add(center[i] - center[i - 1])
    }

    distance.sort()

    var sum = 0
    for (i in 0 until n - k) {
        sum += distance[i]
    }


    write("$sum")
    close()
}