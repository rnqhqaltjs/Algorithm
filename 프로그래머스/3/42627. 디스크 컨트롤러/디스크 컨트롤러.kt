import java.util.*

class Solution {
    fun solution(jobs: Array<IntArray>): Int {
        var answer = 0
        
        val pq1 = PriorityQueue<Pair<Int, Int>>(compareBy { it.first })
        val pq2 = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
        
        for(i in jobs) {
            pq1.add(i[0] to i[1])
        }
        
        var time = 0
        while(pq1.isNotEmpty() || pq2.isNotEmpty()) {
            while(pq1.isNotEmpty() && pq1.peek().first<=time) {
                pq2.offer(pq1.poll())
            }
            
            if(pq2.isNotEmpty()) {
                val (request, during) = pq2.poll()
                time += during
                answer += time - request
            } else if (pq1.isNotEmpty()) {
                time = pq1.peek().first
            }
        }
        
        return answer / jobs.size
    }
}