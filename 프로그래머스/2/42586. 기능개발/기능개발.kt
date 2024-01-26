import java.util.*
import kotlin.math.*

class Solution {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        val queue: Queue<Int> = LinkedList()
        var answer = intArrayOf()
        
        for(i in progresses.indices) {
            var remain = 100-progresses[i]
            var speed = speeds[i]
            
            queue.offer(ceil(remain.toDouble()/speed).toInt())
        }
        
        while(queue.isNotEmpty()) {
            var count =1
            var curValue = queue.poll()
            while(queue.isNotEmpty()) {
                if(queue.peek()<=curValue) {
                    queue.poll()
                    count++
                } else {
                    break
                }
            }
            answer+=count
            println(count)
        }
        
        
        
        return answer
    }
}