class Solution {
    fun solution(n: Int, a: Int, b: Int): Int {
        var answer = 0
 
        var a = a
        var b = b
        for(i in 1..n) {
            a = (a+1)/2
            b = (b+1)/2
            
            if(a==b) {
                answer = i
                break
            }
        }

        return answer
    }
}