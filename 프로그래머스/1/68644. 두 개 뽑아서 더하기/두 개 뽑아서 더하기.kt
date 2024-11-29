class Solution {
    fun solution(numbers: IntArray): IntArray {
        var answer = mutableSetOf<Int>()
        
        for(i in numbers.indices) {
            for(j in i+1 until numbers.size) {
                answer.add(numbers[i]+numbers[j])
            }
        }
        return answer.sorted().toIntArray()
    }
}