class Solution {
    fun solution(n: Int, times: IntArray): Long {
        var answer: Long = 0
        times.sort()
        
        var left: Long = 0
        var right: Long = times[times.size - 1] * n.toLong()
        
        while(left <= right) {
            var mid = (left + right) / 2
            var complete: Long = 0
            
            for(i in times) {
                complete += mid / i
            }
            
            if(complete < n) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        
        return right + 1
    }
}