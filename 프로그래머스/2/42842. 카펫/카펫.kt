class Solution {
    fun solution(brown: Int, yellow: Int): IntArray {
        var answer = intArrayOf(0,0)
        
        var sum = brown + yellow
        
        for(i in 2..sum) {
            var width = sum / i
            var height = i
            
            if((width-2) * (height -2) == yellow) {
                answer[0] = width
                answer[1] = height
                break
            }
        }
        return answer
    }
}