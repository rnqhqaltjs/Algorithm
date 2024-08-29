val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val t = br.readLine().toInt()

    repeat(t) {
        val n = br.readLine().toInt()
        val m = br.readLine().split(" ").map { it.toInt() }
        var max = 0
        var sum = 0L

        for(i in n-1 downTo 0) {
            if(m[i]>=max) {
                max = m[i]
            } else {
                sum+= (max - m[i])
            }
        }

        write("$sum\n")
    }
    close()
}