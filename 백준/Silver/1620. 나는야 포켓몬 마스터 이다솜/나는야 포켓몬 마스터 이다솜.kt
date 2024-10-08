val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val dic = mutableMapOf<Int, String>()
    val dic2 = mutableMapOf<String, Int>()

    repeat(n) {
        val name = br.readLine()
        dic[it + 1] = name
        dic2[name] = it + 1
    }

    repeat(m) {
        val pkm = br.readLine()

        if (pkm.toIntOrNull() == null) {
            write("${dic2[pkm]}\n")
        } else {
            write("${dic[pkm.toInt()]}\n")
        }
    }
    close()
}