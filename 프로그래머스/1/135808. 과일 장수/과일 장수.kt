class Solution {
    fun solution(k: Int, m: Int, score: IntArray): Int {
        var answer: Int = 0
        var appleList = score.sortedDescending().toMutableList()
        
        for(i in m-1 until score.size step(m)) {
            answer += (appleList[i] * m)
        }
        
        return answer
    }
}