val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    var (n, m, k) = br.readLine().split(" ").map { it.toInt() }

    for (i in 0 until k) {
        if (n / 2 >= m) {
            n -= 1
        } else {
            m -= 1
        }
    }

    write("${minOf(n / 2, m)}")
    close()
}