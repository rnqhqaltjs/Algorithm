class Solution {
    fun solution(w: Int, h: Int): Long {
        var answer: Long = 0

        val w = w.toLong()
        val h = h.toLong()
        
        return w * h - (w+h - gcd(w,h))
    }
    
    fun gcd(a: Long, b: Long): Long {
        var r = a % b
        if(r==0L) {
            return b
        } else {
            return gcd(b, r)
        }
    }
}