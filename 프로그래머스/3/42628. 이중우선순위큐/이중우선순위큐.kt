import java.util.*

class Solution {
    fun solution(operations: Array<String>): IntArray {
        var answer = intArrayOf()
        val pq1 = PriorityQueue<Int>()
        val pq2 = PriorityQueue<Int>(reverseOrder())
        
        for(i in operations) {
            val (a, b) = i.split(" ")
            when(a) {
                "I" -> {
                    pq1.offer(b.toInt())
                    pq2.offer(b.toInt())
                }
                "D" -> {
                    when(b) {
                        "1" -> {
                            val max = pq2.poll()
                            pq1.remove(max)
                        }
                        "-1"-> {
                            val min = pq1.poll()
                            pq2.remove(min)
                        }
                    }
                }
            }
        }
        
        if(pq1.isNotEmpty()) {
            return intArrayOf(pq2.peek(), pq1.peek())
        } else {
            return intArrayOf(0,0)
        }        
    }
}