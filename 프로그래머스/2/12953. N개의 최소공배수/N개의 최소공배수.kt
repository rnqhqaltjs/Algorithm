class Solution {
    
    fun gcd(a: Int, b:Int): Int = if(b != 0) gcd(b, a % b) else a
    
    fun solution(arr: IntArray): Int {
        var answer = arr[0]*arr[1] / gcd(arr[0],arr[1])
        
        for(i in 2..arr.size-1) {
            answer = answer*arr[i] / gcd(answer,arr[i])
        }
        return answer
    }
}