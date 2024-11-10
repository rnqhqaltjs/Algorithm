import java.util.*

class Solution {
    fun solution(ingredient: IntArray): Int {
        var answer: Int = 0
        val stack = mutableListOf<Int>()
        
        for(i in ingredient) {
            stack.add(i)
            
            if(stack.size>=4 &&
               stack[stack.size-1] == 1 &&
               stack[stack.size-2] == 3 &&
               stack[stack.size-3] == 2 &&
               stack[stack.size-4] == 1
              ) {
                stack.removeLast()
                stack.removeLast()
                stack.removeLast()
                stack.removeLast()
                
                answer++
            }
        }
        return answer
    }
}