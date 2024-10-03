val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val n = br.readLine().toCharArray()

    n.sortDescending()

    write(String(n))
    close()
}