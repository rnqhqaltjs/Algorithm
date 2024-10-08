val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val n = br.readLine().toInt()

    val myCard = br.readLine().split(" ").map { it.toInt() }.toSet()

    val m = br.readLine().toInt()

    val checkCard = br.readLine().split(" ").map { it.toInt() }.toSet()

    for(i in checkCard) {
        if(i in myCard) {
            write("1 ")
        } else {
            write("0 ")
        }
    }
    close()
}