import java.util.*

class Solution {
    fun solution(number: String, k: Int): String {
        val stack = Stack<Char>()
        var count = 0
        for(i in number) {
            while(stack.isNotEmpty() && stack.peek()<i && count<k) {
                stack.pop()
                count++
            }
            stack.add(i)
        }
        
        while (count < k) {
            stack.pop()
            count++
        }
        
        return stack.joinToString("")
    }
}