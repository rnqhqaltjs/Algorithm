import java.util.*

class Solution {
    fun solution(priorities: IntArray, location: Int): Int {
        val q: Queue<Int> = LinkedList()
        val pq = PriorityQueue<Int>(Collections.reverseOrder())
        var loc = location
        var answer = 0
        
        for(i in priorities.indices) {
            q.add(priorities[i])
            pq.add(priorities[i])
        }
        
        while(true) {
            var firstValue = q.poll()
            if(firstValue == pq.peek()) {
                pq.poll()
                answer++
                if(loc==0) {
                    break
                }
                loc--
            }
            else {
                q.offer(firstValue)
                loc--
                if(loc<0) {
                    loc = pq.size-1
                }
            }
        } 
        return answer
    }
}