val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val n = br.readLine().toInt()

    val distance = br.readLine().split(" ").map { it.toLong() }
    val cost = br.readLine().split(" ").map { it.toInt() }
    var minCost = cost[0]
    var sum:Long = 0

    for(i in 0 until n-1) {
        if(minCost>cost[i]) {
            minCost = cost[i]
        }
        sum +=distance[i] * minCost
    }

    write("$sum")
    close()
}