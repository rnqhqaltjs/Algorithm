class Solution {
    fun solution(k: Int, tangerine: IntArray): Int {
        var sum = 0
        
        var map = mutableMapOf<Int,Int>()
        
        for(i in tangerine) {
            map[i] = map.getOrDefault(i, 0) + 1
        }
        
        map = map.toList().sortedByDescending { it.second }.toMap().toMutableMap()
        
        var count = 0
        for((key, value) in map) {
            if(sum < k) {
                sum += value
                count++
            }
        }
        
        return count
    }
}