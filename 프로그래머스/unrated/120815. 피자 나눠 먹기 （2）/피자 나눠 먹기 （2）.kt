class Solution {
    fun solution(n: Int): Int {
        var answer: Int = 0
        var i = 1
        while(true) {
            if(n*i%6 == 0) {
                answer = n*i/6
                break
            }
            i++
        }
        return answer
    }
}