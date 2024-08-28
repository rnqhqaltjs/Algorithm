val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val n = br.readLine().toMutableList()
    var num0 = 0
    var num1 = 0

    for(i in n) {
        if(i == '0') {
            num0++
        } else {
            num1++
        }
    }

    num0 /= 2
    num1 /= 2

    for(i in n.indices) {
        if(n[i] == '1') {
            n[i] = '9'
            num1--
        }
        if(num1 == 0) {
            break
        }
    }

    for(i in n.size -1 downTo  0) {
        if(n[i] == '0') {
            n[i] = '9'
            num0--
        }
        if(num0 == 0) {
            break
        }
    }

    write(n.filterNot { it == '9' }.joinToString(""))

    close()
}
