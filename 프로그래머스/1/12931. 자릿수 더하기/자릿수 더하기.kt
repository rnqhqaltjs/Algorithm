class Solution {
    fun solution(n: Int): Int {
        var answer = 0

        val n: String = n.toString()
        
        for(i in n) {
            answer += (i - '0').toInt()
        }

        return answer
    }
}