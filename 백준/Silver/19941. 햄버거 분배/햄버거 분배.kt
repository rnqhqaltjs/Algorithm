val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (n, k) = br.readLine().split(" ").map { it.toInt() }

    val table = br.readLine().toMutableList()

    var count = 0

    for(i in table.indices) {
        if(table[i] == 'P') {
            for(j in i -k .. i+k) {
                if(j in 0 until n && table[j] == 'H') {
                    table[j] = '.'
                    count++
                    break
                }
            }
        }
    }

    write("$count")

    close()
}