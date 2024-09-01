val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val title = mutableListOf<String>()
    val powerBoundary = mutableListOf<Int>()


    repeat(n) {
        val (a, b) = br.readLine().split(" ")

        title.add(a)
        powerBoundary.add(b.toInt())
    }

    repeat(m) {
        val power = br.readLine().toInt()

        var left = 0
        var right = n-1

        while(left<=right) {
            val mid = (left + right) / 2

            if(powerBoundary[mid] < power) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        write("${title[left]}\n")
    }

    close()
}