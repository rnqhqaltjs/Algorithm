class Solution {
    fun solution(numbers: IntArray): IntArray {
        var answer: MutableSet<Int> = mutableSetOf()
        for(i in numbers.indices) {
            for(j in i+1 until numbers.size) {
                println(i)
                println(j)
                answer.add(numbers[i]+numbers[j])
            } 
        } 
        return answer.sorted().toIntArray()
    }
}