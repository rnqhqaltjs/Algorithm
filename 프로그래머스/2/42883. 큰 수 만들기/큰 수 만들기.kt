import java.util.*

class Solution {
    fun solution(number: String, k: Int): String {
        var answer = ""
        val stack = Stack<Char>()
        var count = 0
        
        for(i in number) {
            while(stack.isNotEmpty() && count < k && stack.peek()<i) {
                stack.pop()
                count++
            }
            stack.push(i)
        }
        
        while(count< k) {
            stack.pop()
            count++
        }
        return stack.toArray().joinToString("")
    }
}