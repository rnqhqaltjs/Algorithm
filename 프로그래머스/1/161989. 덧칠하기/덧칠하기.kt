class Solution {
    fun solution(n: Int, m: Int, section: IntArray): Int {
        var answer: Int = 0
        var max = 0
        for(i in section.indices) {
            if(section[i]>max) {
                max = section[i]+m-1
                answer++
            }  
        }
        return answer
    }
}