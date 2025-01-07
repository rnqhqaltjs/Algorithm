import java.util.*

class Solution {
    fun solution(s: Array<String>): Array<String> {
        var answer = mutableListOf<String>()

        for(str in s) {
            val stack = Stack<Char>()
            var count = 0
            
            for (ch in str) {
                stack.push(ch)
                if (stack.size >= 3 &&
                    stack[stack.size - 3] == '1' &&
                    stack[stack.size - 2] == '1' &&
                    stack[stack.size - 1] == '0') {
                    repeat(3) { stack.pop() }
                    count++
                }
            }
            
            val sb = StringBuilder()
            var flag = false
            while(stack.isNotEmpty()) {
                val ch = stack.pop()
                sb.insert(0, ch)
                
                if (!flag && ch == '0') {
                    repeat(count) { sb.insert(1, "110") }
                    flag = true
                }
            }
            
            if (!flag) {
                repeat(count) { sb.insert(0, "110") }
            }
            
            answer.add(sb.toString())
        }

        return answer.toTypedArray()
    }
}