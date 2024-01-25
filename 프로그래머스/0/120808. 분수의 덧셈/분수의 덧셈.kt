class Solution {
    fun gcd(a: Int, b:Int): Int = if(b != 0) gcd(b, a % b) else a
    
    fun solution(numer1: Int, denom1: Int, numer2: Int, denom2: Int): IntArray {
        
        var gcdValue = gcd(denom1,denom2)
        var multiple = denom1*denom2/gcdValue
        var number = multiple/denom1 *numer1 + multiple/denom2 * numer2
        var Measure = gcd(number, multiple)
        
        
        var answer: IntArray = intArrayOf(number/Measure, multiple/Measure)
        return answer
    }
}