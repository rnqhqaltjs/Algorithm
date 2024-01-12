import kotlin.math.*

class Solution {
    fun solution(citations: IntArray): Int {
        var answer = 0
        var list = citations
        list.sortDescending()
        
        for(i in list.indices) {
            if(list[i]<i+1) {
                answer = i
                break
            } else {
                answer = list.size
            }
        }
        return answer
    }
}