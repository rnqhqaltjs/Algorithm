class Solution {
    fun solution(arr: IntArray): Int {
        var answer = 0
        var first = arr[0]
        for(i in 1 until arr.size) {
            answer =  first * arr[i] / gcd(first , arr[i])
            
            first = answer
        }
        return answer
    }
    
    fun gcd(a: Int, b: Int): Int {
        if(b!=0) {
            return gcd(b, a%b)
        } else {
            return a
        }
    }
}