val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val s = br.readLine()
    val t = br.readLine().toInt()

    var count = 0
    repeat(t) {
        val n = br.readLine()
        val ring = n+n

        if(ring.contains(s)) {
            count++
        }
    }

    write("$count")
    close()
}