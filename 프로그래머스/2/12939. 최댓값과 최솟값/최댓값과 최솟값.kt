class Solution {
    fun solution(s: String): String {
        var list = s.split(" ").map{it.toInt()}
        var answer = "${list.minOrNull()} ${list.maxOrNull()}"
        return answer
    }
}