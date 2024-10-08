val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val t = br.readLine().toInt()
    val array = mutableListOf<Pair<Int, Int>>()
    repeat(t) {
        val n = br.readLine().split(" ").map { it.toInt() }.toIntArray()

        array.add(n[0] to n[1])
    }

    array.sortWith(compareBy({ it.first }, { it.second }))


    for(i in array) {
        write("${i.first} ${i.second}\n")
    }
    close()
}