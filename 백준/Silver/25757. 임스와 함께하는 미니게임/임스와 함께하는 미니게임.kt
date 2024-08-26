val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (n, t) = br.readLine().split(" ")
    val hashSet = hashSetOf<String>()
    var type = 0

    when(t) {
        "Y" -> { type = 2 }
        "F" -> { type = 3 }
        "O" -> { type = 4 }
    }

    repeat(n.toInt()) {
        val name = br.readLine()
        hashSet.add(name)
    }
    var result = hashSet.size / (type-1)
    
    write("$result\n")

    close()
}