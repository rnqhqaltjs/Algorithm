class Solution {
    fun solution(s: String): Boolean {
        var answer = true
        if((s.length==4 || s.length==6) && s.toIntOrNull() != null ) {
            answer = true
        } else {
            answer = false
        }
        
        return answer
    }
}