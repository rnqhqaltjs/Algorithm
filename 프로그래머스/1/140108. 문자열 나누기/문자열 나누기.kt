class Solution {
    fun solution(s: String): Int {
        var answer = 0
        var same = 0
        var diff = 0
        var start = s[0]
        
        for(i in s.indices) {
            if(same == diff) {
                start = s[i]
                answer++
            }
            
            if(start == s[i]) {
                same++
            } else {
                diff++
            }
        }
        return answer
    }
}