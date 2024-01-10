class Solution {
    fun solution(n: Int): Long {
        var list = LongArray(n+1)
        list[0] = 1
        list[1] = 1
        
        for (i in 2..n) {
            list[i] = (list[i-1] + list[i-2]) %1234567
        }
        return list[n]
    }
}