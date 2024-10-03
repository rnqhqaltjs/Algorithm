val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    var t = br.readLine().toInt()
    val array = mutableListOf<String>()

    repeat(t) {
        val n = br.readLine()
        array.add(n)
    }

    val sortArray = array.sorted()
    val sortDescendingArray = array.sortedDescending()

    if(array == sortArray) {
        write("INCREASING")
    } else if(array == sortDescendingArray) {
        write("DECREASING")
    } else {
        write("NEITHER")
    }
    close()
}