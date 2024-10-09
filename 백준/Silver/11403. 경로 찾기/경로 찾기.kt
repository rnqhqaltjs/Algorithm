val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {

    val n = br.readLine().toInt()

    val graph = Array(n) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }

    for (k in 0 until n) {
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (graph[i][k] == 1 && graph[k][j] == 1) {
                    graph[i][j] = 1
                }
            }
        }
    }

    for (i in 0 until n) {
        write("${graph[i].joinToString(" ")}\n")
    }

    close()
}
