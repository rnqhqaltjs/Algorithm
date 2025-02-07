import java.util.*

class Solution {
    fun solution(s: String): Int {
        var answer = 0
        
        
        var s = s
        for(i in 1 .. s.length) {
            val stack = Stack<Char>()
            s = s[s.length - 1] + s.substring(0, s.length - 1)
            
            for(i in s) {
                if(stack.isEmpty() || i == '(' || i == '[' || i == '{') {
                    stack.push(i)
                } else if((stack.peek()== '(' && i==')') || (stack.peek()== '[' && i==']') || (stack.peek()== '{' && i=='}')) {
                    stack.pop()
                } 
            }
            
            if(stack.isEmpty()) {
                answer++
            }
        }
        
        return answer
    }
}