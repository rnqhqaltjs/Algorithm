val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val n = br.readLine().toInt()
    var array = mutableListOf<Int>()


    for(i in 0 until n) {
        array.addAll(br.readLine().split(" ").map { it.toInt() })
    }

    array = array.sortedDescending().toMutableList()

    write("${array[n-1]}")
    close()
}

