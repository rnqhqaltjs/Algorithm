val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    var (n, a, b) = br.readLine().split(" ").map { it.toInt() }

    var count = 0

    while (b != a) {
        count++

        a = (a + 1) / 2
        b = (b + 1) / 2
    }


    write("$count")
    close()
}