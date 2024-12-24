class Solution {
    fun solution(dots: Array<IntArray>): Int {
        var answer = 0
        
        val x1 = dots[0][0]
        val y1 = dots[0][1]
        val x2 = dots[1][0]
        val y2 = dots[1][1]
        val x3 = dots[2][0]
        val y3 = dots[2][1]
        val x4 = dots[3][0]
        val y4 = dots[3][1]
        
        var slope1 : Double = (y2 - y1) / (x2 - x1).toDouble()
        var slope2 : Double = (y4 - y3) / (x4 - x3).toDouble()
        if(slope1 == slope2) answer = 1
        
        slope1 = (y3 - y1) / (x3 - x1).toDouble()
        slope2 = (y4 - y2) / (x4 - x2).toDouble()
        if(slope1 == slope2) answer = 1
        
        slope1 = (y3 - y2) / (x3 - x2).toDouble()
        slope2 = (y4 - y1) / (x4 - x1).toDouble()
        if(slope1 == slope2) answer = 1
        
        return answer
    }
}