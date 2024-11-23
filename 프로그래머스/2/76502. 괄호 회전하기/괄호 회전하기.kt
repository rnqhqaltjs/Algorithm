import java.util.*

class Solution {
    fun solution(s: String): Int {
        var answer = 0
        var stack = Stack<Char>()
        var str = s
        
        for(i in s.indices) {
            stack.clear()
            str = s.substring(i, s.length) + s.substring(0, i)
            
            for(i in str) {
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