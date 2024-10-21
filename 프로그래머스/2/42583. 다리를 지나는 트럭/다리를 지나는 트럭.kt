import java.util.*

class Solution {
    fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
        var answer = 0
        val bridge = LinkedList<Int>(List(bridge_length) { 0 })
        val wait = LinkedList<Int>(truck_weights.toList())        
        
        while(bridge.isNotEmpty()) {
            answer++
            bridge.poll()
            
            if(wait.isNotEmpty()) {
                if(bridge.sum() + wait.peek() <=weight) {
                    bridge.offer(wait.poll())
                } else {
                    bridge.offer(0)
                }
            }
            
        }
        return answer
    }
}