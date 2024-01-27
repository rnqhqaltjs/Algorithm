import kotlin.math.*

class Solution {
    fun solution(number: Int, limit: Int, power: Int): Int {
        var list: IntArray = intArrayOf()
        var answer: Int = 0
        
        for(i in 1..number) {
            var count = 0
            var root = sqrt(i.toDouble()).toInt()
            for(j in 1..root) {
                if(j*j==i) {
                    count++
                } else if(i%j==0) {
                    count +=2
                }
            }
            list+=count
        }
        
        for(i in list.indices) {
            if(list[i]>limit) {
                list[i]= power
            }
        }
        
        return list.sum()
    }
}