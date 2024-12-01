class Solution {
    fun solution(N: Int, stages: IntArray): IntArray {
        var answer = intArrayOf()
        var map = mutableMapOf<Int, Double>()
        
        for(i in 1..N) {
            var count = 0
            var sum = 0
            for(j in stages.indices) {
                if(i==stages[j]) {
                    count++
                    sum++
                } else if (i<stages[j]) {
                    sum++
                }
                
                if(sum!= 0) {
                    map[i] = count/sum.toDouble()
                } else {
                    map[i] = 0.0
                }
            }
        }
        
        return map.toList().sortedByDescending { it.second }.map { it.first }.toIntArray()
    }
}