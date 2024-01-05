class Solution {
    fun solution(n: Int): IntArray {
        var answer: IntArray = intArrayOf()
        for(i in 1..n step(2))  {
            answer+= i
        }
        return answer
    }
}