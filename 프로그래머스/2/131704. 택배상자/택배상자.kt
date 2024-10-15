import java.util.*
class Solution {
    fun solution(order: IntArray): Int {
        var stack = Stack<Int>()
        
        var idx = 0
        var num = 0
        
        while(idx < order.size) {
            if(num < order[idx]) {
                num++
                stack.push(num)
            } else if (stack.isNotEmpty() && stack.peek() == order[idx]) {
                stack.pop()
                idx++
            } else {
                return idx
            }     
        }
        return idx
    }
}