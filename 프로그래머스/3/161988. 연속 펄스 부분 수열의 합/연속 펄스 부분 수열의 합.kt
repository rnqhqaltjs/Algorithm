class Solution {
    fun solution(sequence: IntArray): Long {
        var answer: Long = 0
        
        var dp1 = LongArray(sequence.size) { 0 }
        var dp2 = LongArray(sequence.size) { 0 }
        var reverse = -1
        
        dp1[0] = sequence[0].toLong()
        dp2[0] = -sequence[0].toLong()
        
        for (i in 1 until sequence.size) {
            val num1 = sequence[i].toLong() * reverse
            val num2 = sequence[i].toLong() * -reverse

            dp1[i] = maxOf(dp1[i - 1] + num1, num1)
            dp2[i] = maxOf(dp2[i - 1] + num2, num2)
            
            reverse = -reverse
        }
         
        return maxOf(dp1.maxOrNull()!!, dp2.maxOrNull()!!)
    }
}