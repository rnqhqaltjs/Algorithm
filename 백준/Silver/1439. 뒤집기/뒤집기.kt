val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val n = br.readLine().toCharArray()

    var count = 0
    for (i in 0 until n.size -1) {

        if (n[i] != n[i + 1]) {
            count++
        }
    }

    write("${(count + 1) / 2}")
    close()
}