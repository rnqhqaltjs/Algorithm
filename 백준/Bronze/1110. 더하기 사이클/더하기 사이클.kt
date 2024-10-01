val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    var n = br.readLine().toInt()

    if (n < 10) n *= 10


    var count = 0
    var temp = n
    while (true) {
        count++
        val a = temp / 10
        val b = temp % 10
        temp = b * 10 + (a + b) % 10

        if (temp == n) {
            break
        }

    }

    write("$count")
    close()
}