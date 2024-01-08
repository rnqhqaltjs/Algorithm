class Solution {
    fun solution(s: String): String {
        var list = s.split(" ").map{it.lowercase()}
        var answer = list.map{it.replaceFirstChar{it.uppercase()}}
        return answer.joinToString(" ")
    }
}