import kotlin.math.*

class Solution {
    fun solution(k: Int, d: Int): Long {
        var answer: Long = 0
        
        for(i in 0..d/k) {
            val longX = i*k
            val longY = (sqrt(d.toDouble().pow(2) - longX.toDouble().pow(2))/k).toLong()
            
            answer += longY + 1L
        }
        return answer
    }
}