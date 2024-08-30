import kotlin.math.min

val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val n = br.readLine()

    val aCount = n.count { it == 'a' }

    var min = Int.MAX_VALUE

    for(i in n.indices) {
        var bCount = 0

        for(j in i until i+aCount) {
            val index = j%n.length

            if(n[index] == 'b') {
                bCount++
            }
        }
        min = min(min, bCount)
    }
    
    write("$min")

    close()
}