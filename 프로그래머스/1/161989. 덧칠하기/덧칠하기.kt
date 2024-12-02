class Solution {
    fun solution(n: Int, m: Int, section: IntArray): Int {
        var answer: Int = 0
        
        
        var idx = 1
        while(idx<=n) {
            if(idx in section) {
                idx+=m
                answer++
            } else {
                idx++
            }
        }
        return answer
    }
}