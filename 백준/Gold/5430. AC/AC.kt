val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val t = br.readLine().toInt()

    repeat(t) {
        val p = br.readLine().toCharArray()
        val n = br.readLine().toInt()
        val inputArray = br.readLine()
        val deque = if (inputArray == "[]") {
            ArrayDeque()
        } else {
            ArrayDeque(inputArray.replace("[", "")
                .replace("]", "").split(",")
                .map { it.toInt() })
        }

        var reverseFlag = false
        var errorFlag = false

        for (i in p) {
            if (i == 'R') {
                reverseFlag = !reverseFlag
            } else {
                if (deque.isEmpty()) {
                    errorFlag = true
                    break
                } else {
                    if (reverseFlag) {
                        deque.removeLast()
                    } else {
                        deque.removeFirst()
                    }
                }
            }
        }

        if (errorFlag) {
            write("error\n")
        } else {
            val result = if (reverseFlag) {
                deque.reversed()
            } else {
                deque
            }
            write("[${result.joinToString(",")}]\n")
        }
    }

    close()
}