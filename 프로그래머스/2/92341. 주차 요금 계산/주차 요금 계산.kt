import kotlin.math.*

class Solution {
    fun solution(fees: IntArray, records: Array<String>): IntArray {
        
        var answer: IntArray = intArrayOf()
        var parkingTime: MutableMap<String,Int> = mutableMapOf()
        var totalTime: MutableMap<String,Int> = mutableMapOf()
        
        for(i in records) {
            var (time, car, act) = i.split(" ")
            
            val (hour, minute) = time.split(":").map { it.toInt() }
            val totalMinute = hour * 60 + minute
            
            if(act == "IN") {
                parkingTime[car] = totalMinute
            } else {
                totalTime[car] = totalTime.getOrDefault(car, 0) + totalMinute - parkingTime[car]!!
                parkingTime.remove(car)
            }
        }
        
        for((key, value) in parkingTime) {
            totalTime[key] = totalTime.getOrDefault(key, 0) + (23*60+59) -value
        }
        
        totalTime = totalTime.toSortedMap(compareBy {it} )
        
        for((key, value) in totalTime) {
            var totalFee = fees[1] + ceil((value-fees[0])/fees[2].toDouble()).toInt() * fees[3]
            
            if(fees[0]>value) {
                answer+= fees[1]
            } else {
                answer+= totalFee
            } 
        }
        
        return answer
    }
}