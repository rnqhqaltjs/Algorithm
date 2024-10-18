import java.util.*

class Solution {
    fun solution(numbers: IntArray): IntArray {
        val answer = IntArray(numbers.size) { -1 }
        val stack = Stack<Int>()
        
        for(i in numbers.indices) {
            while(stack.isNotEmpty() && numbers[stack.peek()] < numbers[i]) {
                answer[stack.pop()] = numbers[i]
            }
            stack.push(i)
        }
        return answer
    }
}