import java.util.*

class Solution {
    fun solution(order: IntArray): Int {
        var answer: Int = 0
        val stack = Stack<Int>()
        var idx = 0
        
        for(i in 1..order.size) {
            stack.push(i)
            
            while(stack.isNotEmpty() && stack.peek() == order[idx]) {
                idx++
                stack.pop()
            }
        } 
        
        return idx
    }
}