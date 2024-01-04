class Solution {
    fun solution(s1: Array<String>, s2: Array<String>): Int {
        var answer: Int = 0
        for(i in s1) {
            for (j in s2) {
                if(i==j) {
                    answer++
                }
            }
        }
        return answer
    }
}