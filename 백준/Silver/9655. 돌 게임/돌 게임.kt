val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val n = br.readLine().toInt()

    if(n%2 == 1) {
        write("SK")
    } else {
        write("CY")
    }

    close()
}