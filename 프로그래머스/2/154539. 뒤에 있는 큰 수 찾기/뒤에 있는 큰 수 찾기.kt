import java.util.*

class Solution {
    fun solution(numbers: IntArray): IntArray {
        var answer = IntArray(numbers.size) { -1 }
        val stack = Stack<Int>()
        
        for(i in numbers.indices) {
            while(stack.isNotEmpty() && numbers[i] > numbers[stack.peek()]) {
                answer[stack.pop()] = numbers[i]
            }
            
            stack.push(i)
        }
        return answer
    }
}