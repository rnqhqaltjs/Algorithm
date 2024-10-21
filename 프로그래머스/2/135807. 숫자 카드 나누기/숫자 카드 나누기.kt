class Solution {
    fun solution(arrayA: IntArray, arrayB: IntArray): Int {
        var answer: Int = 0
        
        var max1 = 0
        var max2 = 0
        
        var gcd1 = arrayA[0]
        var gcd2 = arrayB[0]
        
        for(i in 1 until arrayA.size) {
            gcd1 = GCD(gcd1, arrayA[i])
            gcd2 = GCD(gcd2, arrayB[i])
        }
        
        if(valid(arrayA, gcd2)) {
            answer = maxOf(answer, gcd2)
        }
        
        if(valid(arrayB, gcd1)) {
            answer = maxOf(answer, gcd1)
        }
        
        
        return answer
    }
    
    fun GCD(a: Int, b: Int): Int {
        var r = a%b
        if (r == 0)
            return b
        else
            return GCD(b, r)
    }
    
    fun valid(a:IntArray, b: Int):  Boolean {
        for(i in a) {
            if(i%b==0) {
                return false
            }
        }
        return true
    }
}