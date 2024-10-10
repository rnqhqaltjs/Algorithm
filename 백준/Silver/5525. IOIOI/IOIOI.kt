val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {

    val n = br.readLine().toInt()
    val m = br.readLine().toInt()
    val s = br.readLine()

    var index = 0
    var count = 0
    var answer = 0
    while (index < m - 2) {
        if (s[index] == 'I' && s[index + 1] == 'O' && s[index + 2] == 'I') {
            index += 2
            count++
            if (count == n) {
                count--
                answer++
            }
        } else {
            index++
            count = 0
        }
    }

    write("$answer")

    close()
}
