val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val array = mutableSetOf<String>()
    val result = mutableListOf<String>()

    repeat(n) {
        array.add(br.readLine())
    }

    repeat(m) {
        val string = br.readLine()
        if(array.contains(string)) {
            result.add(string)
        }
    }

    result.sort()
    write("${result.size}\n")
    for(i in result) {
        write("$i\n")
    }

    close()
}