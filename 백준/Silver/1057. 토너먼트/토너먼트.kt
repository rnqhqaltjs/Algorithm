val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    var (n, a, b) = br.readLine().split(" ").map { it.toInt() }

    var count = 0

    while (b != a) {
        count++

        a = a / 2 + a % 2
        b = b / 2 + b % 2
    }


    write("$count")
    close()
}