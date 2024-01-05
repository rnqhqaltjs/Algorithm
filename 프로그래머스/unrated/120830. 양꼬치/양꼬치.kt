class Solution {
    fun solution(n: Int, k: Int): Int {
        var result = 0
        result = n/10
        var answer: Int = n*12000 + k * 2000 - result*2000
        return answer
    }
}