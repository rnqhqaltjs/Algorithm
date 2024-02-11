class Solution {
    fun solution(dots: Array<IntArray>): Int {
        var answer: Int = 0
        var x = mutableListOf<Int>()
        var y = mutableListOf<Int>()
        
        for(i in dots.indices) {
            x.add(dots[i][0])
            y.add(dots[i][1])
        }
        
        answer += (x.maxOrNull()!!-x.minOrNull()!!) * (y.maxOrNull()!!-y.minOrNull()!!)
        return answer
    }
}