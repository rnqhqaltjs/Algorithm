class Solution {
    fun gcd(a: Int, b:Int): Int = if(b != 0) gcd(b, a % b) else a
    fun solution(a: Int, b: Int): Int {
        
        var x = b/gcd(a,b)
        while(x!=1) {
            if(x%5 == 0) {
                x = x/5
            } else if (x%2==0) {
                x = x/2
            }
            else {
                return 2
            }
        }
        return 1
    }
}