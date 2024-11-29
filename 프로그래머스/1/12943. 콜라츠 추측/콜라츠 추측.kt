class Solution {
    fun solution(num: Int): Int {
        var answer: Long = 0
        var n: Long = num.toLong()
        
        if(n==1L) {
            return 0
        }
        
        for(i in 1..500) {
            if(n % 2== 0L) {
                n=n/2
            } else {
                n = n*3+1
            }
            
            if(n==1L) {
                return i
            }
        }
        
        return -1
    }
}