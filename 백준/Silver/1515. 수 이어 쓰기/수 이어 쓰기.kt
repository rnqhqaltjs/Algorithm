val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val n = br.readLine()

    var num = 0
    var idx = 0

    while (true) {
        num++

        for(j in 0 until num.toString().length) {
            if(n[idx] == num.toString()[j]) {
                idx++
            }

            if(idx == n.length) {
                break
            }
        }

        if(idx == n.length) {
            break
        }
    }

    write("$num")
    close()
}