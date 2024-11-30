class Solution {
    fun solution(k: Int, score: IntArray): IntArray {
        var answer = mutableListOf<Int>()
        var list = mutableListOf<Int>()
        
        
        for(i in score) {
            list.add(i)
            list.sort()
            if(list.size>k) {
                list.removeFirst()
            }
            answer.add(list[0])
        }
        return answer.toIntArray()
    }
}