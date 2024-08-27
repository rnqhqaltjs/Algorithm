val br = System.`in`.bufferedReader()
val switchN = br.readLine().toInt()
val array = (mutableListOf(0) +  br.readLine().split(" ").map { it.toInt() }).toMutableList()
val studentN = br.readLine().toInt()
fun main() = with(System.out.bufferedWriter()) {
    repeat(studentN) {
        val (sex, switch) = br.readLine().split(" ").map { it.toInt() }

        when(sex) {
            1 -> {
                for(i in 1 until array.size) {
                    if(i%switch == 0) {
                       change(i)
                    }
                }
            }
            2 -> {
                change(switch)
                for(i in 1 until array.size/2) {
                    if(switch - i >= 1 && switch + i <= switchN && array[switch - i] == array[switch + i]) {
                        change(switch - i)
                        change(switch + i)
                    } else {
                        break
                    }
                }

            }
        }
    }

    for(i in 1 until array.size) {
        write("${array[i]} ")

        if(i%20 == 0) {
            write("\n")
        }
    }


    close()
}

fun change(n: Int) {
    if(array[n] == 0) {
        array[n] = 1
    } else {
        array[n] = 0
    }
}