class Solution {
    fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
        var answer = mutableListOf<Int>()
        
        for(i in commands) {
            val sliced = array.slice(i[0] - 1 until i[1]).sorted()
            
            answer.add(sliced[i[2] - 1])
        }
        return answer.toIntArray()
    }
}