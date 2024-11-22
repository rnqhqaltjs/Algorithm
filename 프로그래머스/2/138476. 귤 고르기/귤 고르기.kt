class Solution {
    fun solution(k: Int, tangerine: IntArray): Int {
        var answer: Int = 0
        var map = mutableMapOf<Int, Int>()
        
        for(i in tangerine) {
            map[i] = map.getOrDefault(i, 0) + 1
        }
        
        var sortedMap = map.toList().sortedByDescending { it.second }.toMap()
        
        var count = 0
        var sum = 0
        for((key, value) in sortedMap) {
            if(sum<k) {
                sum+=value
                count++
            }
        }
        return count
    }
}