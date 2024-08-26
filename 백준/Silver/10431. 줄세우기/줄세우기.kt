val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val n = br.readLine().toInt()


    repeat (n) {
        val p =br.readLine().split(" ").map { it.toInt() }

        var count = 0

        for(i in 1 until p.size) {
            for(j in 1 until i) {
                if(p[j]>p[i]) {
                    count++
                }
            }
        }

        write("${p[0]} $count\n")

    }

    close()
}