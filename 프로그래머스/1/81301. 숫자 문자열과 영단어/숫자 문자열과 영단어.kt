val map: MutableMap<String, Int> = mutableMapOf("zero" to 0, "one" to 1, "two" to 2, "three" to 3, "four" to 4, "five" to 5, "six" to 6, "seven" to 7, "eight" to 8, "nine" to 9)


class Solution {
    fun solution(s: String): Int {
        var answer = s
        
        for((key, value) in map) {
            if(answer.contains(key)) {
                answer = answer.replace(key, value.toString())
            }
        }
        return answer.toInt()
    }
}