val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val t = br.readLine().toInt()

    val array = mutableListOf<Int>()
    repeat(t) {
        val n = br.readLine().toInt()

        if(n == 0) {
            array.removeLast()
        } else {
            array.add(n)
        }
    }
    
    write("${array.sum()}")

    close()
}