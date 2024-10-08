val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val n = br.readLine().map { it - '0' }
    var sum = 0

    if (n.contains(0)) {
        for (i in n) {
            sum += i
        }
        if (sum % 3 == 0) {
            val result = n.sortedDescending().joinToString("")

            write("$result")
        } else {
            write("-1")
        }
    } else {
        write("-1")
    }



    close()
}