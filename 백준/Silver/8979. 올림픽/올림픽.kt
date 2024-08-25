val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (n, k) =br.readLine().split(" ").map { it.toInt() }


    val table = Array(n) { IntArray(4) }

    repeat(n) { i ->
        table[i] =br.readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    table.sortWith(compareBy({ -it[1] }, { -it[2] }, { -it[3] }))

    for(i in 0 until n) {
        if(table[i][0] == k) {
            print(i+1)
        }
    }
    close()
}