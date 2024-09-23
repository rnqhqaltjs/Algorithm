val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    var k = br.readLine().toInt()

    var n = 2

    while (k > n) {
        n *= 2
    }

    write("$n\n")

    var count = 0
    while (k > 0) {
        if (k >= n) {
            k -= n
        } else {
            n /= 2
            count++
        }
    }
    
    write("$count\n")
    close()
}