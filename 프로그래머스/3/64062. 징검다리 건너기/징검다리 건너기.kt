class Solution {
    fun solution(stones: IntArray, k: Int): Int {  
        var start = 0
        var end = stones.maxOrNull()!!
        
        while(start <= end) {
            var mid = (start + end) / 2
            
            if(checkBridge(mid, stones, k)) {
                start = mid + 1
            } else {
                end = mid - 1
            }
        }
        return start
    }
    
    fun checkBridge(mid: Int, stones: IntArray, k: Int) : Boolean {
        var count = 0
        
        for(i in stones) {
            if(i-mid <= 0) {
                count++
            } else {
                count = 0
            }
                    
            if(count == k) {
                return false
            }
        }

        return true
    }
}