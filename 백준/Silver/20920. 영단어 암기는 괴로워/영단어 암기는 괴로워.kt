val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (n,m) = br.readLine().split(" ").map { it.toInt() }
    val map = mutableMapOf<String,Int>()

    for(i in 0 until n) {
        val word = br.readLine()
        if(word.length>= m) {
            map[word] = map.getOrDefault(word, 0) +1
        }
    }

    val abc = map.entries.sortedWith(
        compareBy({-it.value},{-it.key.length},{it.key})
    )

    for(i in abc) {
        write("${i.key}\n")
    }
    close()
}