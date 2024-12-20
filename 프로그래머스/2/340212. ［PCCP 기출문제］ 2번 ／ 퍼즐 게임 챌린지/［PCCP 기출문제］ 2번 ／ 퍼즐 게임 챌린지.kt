class Solution {
    fun solution(diffs: IntArray, times: IntArray, limit: Long): Int {
        var answer: Int = 0
        
        var start = 1
        var end = diffs.maxOrNull()!!
        var mid: Int
        
        while(start<=end) {
            mid = (start + end) / 2
            
            if(puzzle(mid, diffs, times, limit)) {
                end = mid - 1
            } else {
                start = mid + 1
            }
            
        }
        
        return start
    }
    
    fun puzzle(level: Int, diffs: IntArray, times: IntArray, limit: Long): Boolean {
        var count: Long = 0
        for(i in diffs.indices) {
            if(diffs[i] <= level) {
                count += times[i]
            } else {
                count += (diffs[i] - level) * (times[i] + times[i-1]) + times[i]
            }
        }
        
        return count<=limit
    }
}