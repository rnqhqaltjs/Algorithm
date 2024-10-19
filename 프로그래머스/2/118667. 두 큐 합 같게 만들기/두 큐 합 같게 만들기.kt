import java.util.*

class Solution {
    fun solution(queue1: IntArray, queue2: IntArray): Int {
        val q1 = ArrayDeque<Long>()
        val q2 = ArrayDeque<Long>()
        
        for(i in queue1) {
            q1.offer(i.toLong())
        }
        
        for(i in queue2) {
            q2.offer(i.toLong())
        }
        
        var sum1 = q1.sum()
        var sum2 = q2.sum()
        
        var idx = 0
        var max = q1.size * 4
        while(idx <= max) {
            if(sum1 == sum2) {
                return idx
            }
            
            if(sum1>sum2) {
                val element = q1.removeFirst()
                q2.offer(element)
                sum2 += element
                sum1 -= element
            } else {
                val element = q2.removeFirst()
                q1.offer(element)
                sum1 += element
                sum2 -= element
            }
            
            idx++
        }
        
        return -1
    }
}