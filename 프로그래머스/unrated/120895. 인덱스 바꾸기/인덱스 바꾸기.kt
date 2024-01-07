import java.util.*

class Solution {
    fun solution(my_string: String, num1: Int, num2: Int): String {
        var answer = my_string.toCharArray()
        val temp = answer[num1]
        answer[num1] = answer[num2]
        answer[num2] = temp
        return answer.joinToString("")
    }
}