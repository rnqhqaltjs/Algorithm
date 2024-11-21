class Solution {
    fun solution(n: Int): Int {
        var answer = 0
        var list = IntArray(n+1)
        
        list[0] = 0
        list[1] = 1
        
        for(i in 2..n) {
            list[i] = (list[i-1] + list[i-2]) % 1234567
        }
        return list[n] 
    }
}