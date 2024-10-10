val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {

    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val array = br.readLine().split(" ").map { it.toInt() }.toIntArray()

    val prefixSum = IntArray(n+1)

    for(i in 1..n) {
        prefixSum[i] = prefixSum[i-1] + array[i-1]
    }
    repeat(m) {
        val (i, j) = br.readLine().split(" ").map { it.toInt() }

        write("${prefixSum[j] - prefixSum[i-1]}\n")
    }

    close()
}
