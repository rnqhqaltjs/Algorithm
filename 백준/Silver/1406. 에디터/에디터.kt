import java.util.Stack

val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val stack1 = Stack<Char>()
    val stack2 = Stack<Char>()
    for(i in br.readLine()) {
        stack1.push(i)
    }

    val n = br.readLine().toInt()

    repeat(n) {
        val m = br.readLine().split(" ")
        when(m[0][0]) {
            'L' -> {
                if(stack1.size !=0) {
                    stack2.push(stack1.pop())
                }
            }
            'D' -> {
                if(stack2.size!=0) {
                    stack1.push(stack2.pop())
                }
            }
            'B' -> {
                if(stack1.size !=0) {
                    stack1.pop()
                }
            }

            'P' -> {
                val alpha = m[1][0]
                stack1.add(alpha)
            }
        }
    }

    while (stack1.isNotEmpty()) {
        stack2.push(stack1.pop())
    }

    while (stack2.isNotEmpty()) {
        write("${stack2.pop()}")
    }
    close()
}