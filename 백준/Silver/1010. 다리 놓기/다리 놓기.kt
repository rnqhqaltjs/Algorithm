val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val t = br.readLine().toInt()

    repeat(t) {
        var result = 1L
        val (n, m) = br.readLine().split(" ").map { it.toInt() }

        for (i in 1..n) {
            result = result * (m - i + 1) / i
        }

        write("$result\n")
    }
    
    close()
}