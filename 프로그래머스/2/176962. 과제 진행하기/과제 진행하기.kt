import java.util.*

class Solution {
    fun solution(plans: Array<Array<String>>): Array<String> {
        var answer = mutableListOf<String>()
        val plan = plans.sortedWith(compareBy{ it[1] })
        val pauseDq = ArrayDeque<Pair<String,Int>>()
        
        for(i in plan.indices) {
            val subject = plan[i][0]
            val sTime = plan[i][1].split(":")[0].toInt()*60 + plan[i][1].split(":")[1].toInt()
            val remain = plan[i][2].toInt()
            
            if(i!=plan.size - 1) {
                val nTime = plan[i+1][1].split(":")[0].toInt()*60 + plan[i+1][1].split(":")[1].toInt()
                
                if(sTime+remain <= nTime) {
                    answer.add(subject)
                    var time = nTime - (sTime + remain)
                    
                    while(time>0 && pauseDq.isNotEmpty()) {
                        if(time - pauseDq.last().second >=0) {
                            time -= pauseDq.last().second
                            answer.add(pauseDq.removeLast().first)
                        } else {
                            val top = pauseDq.removeLast()
                            pauseDq.addLast(top.copy(second = top.second - time))
                            time = 0
                        }
                    }
                } else {
                    pauseDq.addLast(subject to (sTime + remain) - nTime)
                }
            } else {
                answer.add(subject)
            }
        } 
        
        while(pauseDq.isNotEmpty()) {
            answer.add(pauseDq.removeLast().first)
        }
        
        return answer.toTypedArray()
    }
}