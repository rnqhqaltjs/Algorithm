val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val t = br.readLine().toInt()

    repeat(t) {
        val n = br.readLine()

        val answer = twoPointer(0, n.length - 1, false, n)

        write("$answer\n")
    }
    close()
}

fun twoPointer(left: Int, right: Int, isDeleted: Boolean, str: String): Int {
    var left = left
    var right = right

    while (left <= right) {
        if (str[left] == str[right]) {
            left++
            right--
        } else {
            return if(!isDeleted && (twoPointer(left + 1, right, true, str) == 0 || twoPointer(left, right - 1, true, str) == 0)) {
                1
            } else {
                2
            }
        }
    }

    return 0
}