val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    var s = br.readLine()

    s = s.replace("pi"," ")
    s = s.replace("ka", " ")
    s = s.replace("chu", " ")

    s = s.trim()

    if(s.isEmpty()) {
        write("YES")
    } else {
        write("NO")
    }
    close()
}