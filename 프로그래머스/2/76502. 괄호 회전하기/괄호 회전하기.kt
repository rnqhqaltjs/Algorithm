import java.util.*

class Solution {
    fun solution(s: String): Int {
        var str = s
        val stack = Stack<Char>()
        var answer = 0

        for(i in str.indices) {
            stack.clear()
            str = s.substring(i until str.length) + s.substring(0 until i)
            for(j in str.indices) {
                if(str[j]=='['||str[j]=='('||str[j]=='{'){
                    stack.push(str[j])
                }
                else if(stack.empty()){
                    stack.push(str[j])
                } 
                else {
                    if ((stack.peek() == '[' && str[j] == ']') ||
                    (stack.peek() == '(' && str[j] == ')') ||
                    (stack.peek() == '{' && str[j] == '}')) {
                        stack.pop()
                    }
                }
            }
            if(stack.empty()) {
                    answer++
                }
        }
        
        return answer
    }
}