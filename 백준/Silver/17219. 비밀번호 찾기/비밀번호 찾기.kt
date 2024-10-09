val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val dic = mutableMapOf<String, String>()

    repeat(n) {
        val (site, password) = br.readLine().split(" ")
        dic[site] = password
    }

    repeat(m) {
        val answer = br.readLine()

        write("${dic[answer]}\n")
    }
    close()
}