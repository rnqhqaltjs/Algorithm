val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val s = br.readLine()
    var t = br.readLine()

    while (t.length > s.length) {
        if (t[t.length - 1] == 'A') {
            t = t.substring(0, t.length - 1)
        } else {
            t = t.substring(0, t.length - 1)
            t = t.reversed()
        }
    }

    if(s.equals(t)) {
        write("1")
    } else {
        write("0")
    }
    close()
}