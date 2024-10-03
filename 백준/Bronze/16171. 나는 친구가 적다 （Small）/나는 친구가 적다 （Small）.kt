val br = System.`in`.bufferedReader()
val number = arrayOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9')
fun main() = with(System.out.bufferedWriter()) {
    val s = br.readLine().toCharArray()
    val k = br.readLine().toCharArray()
    val temp = mutableListOf<Char>()
    for (i in s.indices) {
        if (s[i] !in number) {
            temp.add(s[i])
        }
    }

    if (String(temp.toCharArray()).contains(String(k))) {
        write("1")
    } else {
        write("0")
    }

    close()
}