class Solution {
    fun solution(brown: Int, yellow: Int): IntArray {
        var answer = intArrayOf()
        var area = brown + yellow
        
        for(i in 2..area) {
            var height = i
            var width = area / i
            
            if(yellow == (height - 2) * (width - 2)) {
                answer = intArrayOf(width, height)
                break
            }
        }
        return answer
    }
}