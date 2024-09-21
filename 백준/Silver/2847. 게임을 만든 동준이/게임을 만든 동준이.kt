val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val t = br.readLine().toInt()
    val score = mutableListOf<Int>()
    repeat(t) {
        val n = br.readLine().toInt()
        score.add(n)
    }

    var count = 0
    var current = score[score.size - 1]
    for (i in score.size - 2 downTo 0) {
        if(score[i]>=current) {
            while(current<=score[i]) {
                score[i] = score[i] -1
                count++
            }
        }
        current = score[i]
    }

    write("$count")
    close()
}