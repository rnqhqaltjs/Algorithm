val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val one = mutableListOf<Int>()
    val six = mutableListOf<Int>()

    repeat(m) {
        val brand = br.readLine().split(" ").map { it.toInt() }

        six.add(brand[0])
        one.add(brand[1])
    }

    one.sort()
    six.sort()

    if (one[0] * 6 > six[0]) {
        if (six[0] < (n % 6) * one[0]) {
            write("${(n / 6 + 1) * six[0]}")
        } else {
            write("${(n / 6) * six[0] + (n % 6) * one[0]}")
        }
    } else {
        write("${one[0] * n}")
    }

    close()
}