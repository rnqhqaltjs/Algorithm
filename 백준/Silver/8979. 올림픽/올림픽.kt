val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (n, k) =br.readLine().split(" ").map { it.toInt() }
    var idx = 0

    val table = Array(n) { IntArray(4) }

    for(i in 0 until n) {
        table[i] =br.readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    table.sortWith(compareBy({ -it[1] }, { -it[2] }, { -it[3] }))

    for(i in 0 until n) {
        if(table[i][0] == k) {
            idx = i
        }
    }
    for(i in 0 until n) {
        if(table[idx][1] == table[i][1] && table[idx][2] == table[i][2] && table[idx][3] == table[i][3]) {
            print(i+1)
            break
        }
    }
    close()
}