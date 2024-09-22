val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    var document = br.readLine()
    val word = br.readLine()

    var count = 0
    while (document.contains(word)) {
        val idx = document.indexOf(word)
        document = document.substring(idx + word.length)
        count++
    }

    write("$count")
    close()
}