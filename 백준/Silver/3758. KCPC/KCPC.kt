import kotlin.math.max

val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val T= br.readLine().toInt()

    data class info(
        val id : Int,
        val score: Int,
        val submit:  Int,
        val time: Int
    )

    repeat(T) {
        val (n,k,t,m) = br.readLine().split(" ").map { it.toInt() }
        val score = mutableMapOf<Int, MutableList<Int>>()
        val time = mutableMapOf<Int, Int>()
        val submit = mutableMapOf<Int, Int>()

        for (i in 1..n) {
            score[i] = MutableList(k + 1) { 0 }
        }

        repeat(m) { index ->
            val (i,j,s) = br.readLine().split(" ").map { it.toInt() }

            score[i]?.set(j, max(score[i]?.get(j) ?: 0,s))
            submit[i] = submit.getOrDefault(i, 0) + 1
            time[i] = index

        }

        val array = mutableListOf<info>()

        for (i in 1..n) {
            array.add(
                info(
                    i,
                    score[i]?.sum() ?: 0,
                    submit[i] ?: 0,
                    time[i] ?: 0
                )
            )
        }

        array.sortWith(compareBy({ - it.score},{ it.submit }, { it.time }))

        val rank = array.indexOfFirst { it.id == t } + 1

        write("$rank\n")
    }
    close()
}


