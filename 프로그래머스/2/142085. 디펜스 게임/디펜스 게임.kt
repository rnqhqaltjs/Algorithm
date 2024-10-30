import java.util.*

class Solution {
    fun solution(n: Int, k: Int, enemy: IntArray): Int {
        var answer: Int = 0
        var soldier = n
        var skill = k
        val pq = PriorityQueue<Int>(Collections.reverseOrder())
        
        for(i in enemy) {
            pq.offer(i)
            soldier -= i
            
            while(soldier<0 && skill>0) {
                soldier += pq.poll()
                skill--
            }
            
            if(soldier<0) break
            
            answer++
        }
        return answer
    }
}