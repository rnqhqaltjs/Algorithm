import kotlin.math.abs

val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val n = br.readLine().toInt()
    val list = br.readLine().split(" ").map { it.toInt() }

    var left = 0
    var right = n-1
    var lesLiquid = abs(list[left] + list[right])
    var leftLiquid = list[left]
    var rightLiquid = list[right]

    while(left<right) {
        val tempLiquid = list[left] + list[right]

        if(lesLiquid > abs(tempLiquid)) {
            lesLiquid = abs(tempLiquid)
            leftLiquid = list[left]
            rightLiquid = list[right]
        }

        if(tempLiquid < 0) {
            left++
        } else {
            right--
        }
    }
    write("$leftLiquid $rightLiquid\n")

    close()
}