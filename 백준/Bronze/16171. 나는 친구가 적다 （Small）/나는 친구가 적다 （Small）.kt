val br = System.`in`.bufferedReader()
val number = arrayOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9')
fun main() = with(System.out.bufferedWriter()) {
    val s = br.readLine()
    val k = br.readLine()
    var temp = ""
    for (i in s.indices) {
        if (s[i] !in number) {
            temp+=s[i]
        }
    }

    if (temp.contains(k)) {
        write("1")
    } else {
        write("0")
    }

    close()
}