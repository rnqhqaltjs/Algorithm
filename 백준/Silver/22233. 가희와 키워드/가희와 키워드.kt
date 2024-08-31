val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val note = hashSetOf<String>()

    for(i in 0 until n) {
        note.add(br.readLine())
    }

    for(i in 0 until m) {
        val list = br.readLine().trim().split(",")
        for(j in list) {
            note.remove(j)
        }

        write("${note.size}\n")

    }

    close()
}
