val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val n = br.readLine().toInt()
    val meet = mutableListOf<Pair<Int, Int>>()
    repeat(n) {
        val line = br.readLine().split(" ").map { it.toInt() }
        meet.add(line[0] to line[1])
    }

    meet.sortWith(compareBy({ it.second }, { it.first }))

    var count = 1
    var end = meet[0].second
    for (i in 1 until n) {
        if (meet[i].first >= end) {
            count++
            end = meet[i].second
        }
    }

    write("$count")
    close()
}