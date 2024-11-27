import java.util.*
import kotlin.math.*

class Solution {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        var answer = mutableListOf<Int>()
        val q = LinkedList<Int>()
        
        for(i in progresses.indices) {
            val remain = 100 - progresses[i]
            
            q.offer(ceil(remain/speeds[i].toDouble()).toInt())
        }
        
        while(q.isNotEmpty()) {
            var current = q.poll()
            var count = 1
            
            while(q.isNotEmpty()) {
                if(q.peek()<= current) {
                    q.poll()
                    count++
                } else {
                    break
                }
            }
            
            answer.add(count)
        }
        
        return answer.toIntArray()
    }
}