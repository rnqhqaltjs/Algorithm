class Solution {
    fun solution(k: Int, score: IntArray): IntArray {
        var answer: IntArray = intArrayOf()
        var list: IntArray = intArrayOf()
        
        for(i in score) {
            list+=i
            list.sortDescending()
            if(list.size>k) {
                answer+= list[k-1]
            } else {
                answer+=list.last()
            }  
        }
        return answer
    }
}