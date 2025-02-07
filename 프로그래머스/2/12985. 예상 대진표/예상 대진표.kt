class Solution {
    fun solution(n: Int, a: Int, b: Int): Int {
        var answer = 0
        
        var a = a
        var b = b
        
        while(true) {
            answer++
            a = (a + 1) / 2
            b = (b + 1) / 2
            
            if(a == b) {
                break
            }
        }

        return answer
    }
}