val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    var (n, m) = br.readLine().split(" ").map { it.toInt() }
    val score = mutableListOf<Int>()
    repeat(n) {
        val info = br.readLine().split(" ")
        val p = info[0].toInt()
        val l = info[1].toInt()

        val array = br.readLine().split(" ").map { it.toInt() }.toIntArray()

        array.sortDescending()

        if(array.size >= l) {
            score.add(array[l-1])
        } else {
            score.add(1)
        }
    }

    score.sort()

    var count = 0
    for(i in score) {
        m -= i
        if(m<0) {
            break
        }
        count++
    }

    write("$count")
    close()
}