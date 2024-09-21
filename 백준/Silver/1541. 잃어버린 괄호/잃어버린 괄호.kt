val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val n = br.readLine()

    val number = n.split("-", "+").map { it.toInt() }.toIntArray()
    val operator = mutableListOf<Char>()

    for (i in n) {
        if (i == '-' || i == '+') {
            operator.add(i)
        }
    }

    for (i in 0 until operator.size - 1) {
        if (operator[i] == '-') {
            operator[i + 1] = '-'
        }
    }

    var sum = number[0]
    for (i in operator.indices) {
        if (operator[i] == '-') {
            sum -= number[i + 1]
        } else {
            sum += number[i + 1]
        }
    }

    write("$sum")
    close()
}