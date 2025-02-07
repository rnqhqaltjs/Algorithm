class Solution {
    fun solution(arr: IntArray): Int {
        var answer = 0
        var current = arr[0]
        
        for(i in 1 until arr.size) {
            current = current * arr[i] / gcd(current, arr[i])
        }
        return current
    }
    
    fun gcd(a: Int, b: Int) : Int {
        var r = a % b
        if(r == 0) {
            return b
        } else {
            return gcd(b,r)
        }
    }
}