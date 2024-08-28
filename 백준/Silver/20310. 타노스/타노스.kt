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

    var temp0 = 0
    var temp1 = 0

    for(i in n.indices) {
        if(n[i] == '1') {
            n.removeAt(i)
            temp1++
        }
        if(num1/2 == temp1) {
            break
        }
    }

    for(i in n.size -1 downTo  0) {
        if(n[i] == '0') {
            n.removeAt(i)
            temp0++
        }
        if(num0/2 == temp0) {
            break
        }
    }

    write(n.joinToString(""))

    close()
}

