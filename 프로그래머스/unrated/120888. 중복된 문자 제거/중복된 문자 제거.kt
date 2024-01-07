class Solution {
    fun solution(my_string: String): String {
        var answer = my_string.toCharArray()
        answer = answer.distinct().toCharArray()
        return String(answer)
    }
}