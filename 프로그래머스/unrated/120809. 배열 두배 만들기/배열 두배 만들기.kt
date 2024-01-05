class Solution {
    fun solution(numbers: IntArray): IntArray {
        var answer: IntArray = intArrayOf()
        for(i in numbers) {
            answer+=i*2
        }
        
        return answer
    }
}