class Solution {
    fun solution(N: Int, stages: IntArray): IntArray {
        var answer = intArrayOf()
        var countMap: MutableMap<Int,Int> = mutableMapOf()
        var stageMap: MutableMap<Int,Double> = mutableMapOf()
        var remain = stages.size
        
        for(i in stages) {
            if(i<=N) {
                countMap[i] = countMap.getOrDefault(i,0)+1
            }
        }
        
        for(i in 1..N) {
            if(!countMap.containsKey(i)) {
                countMap[i] = 0
            }
        }
        
        for(i in 1..N) {
            stageMap[i] = 0.0
        }
        
        for((key, value) in countMap.toSortedMap()) {
            if(countMap[key]!=0) {
                stageMap[key] = value/remain.toDouble()
                remain = remain - value
            }
        }
        
        return stageMap.toList().sortedByDescending { it.second }.toMap().keys.toIntArray()
    }
}