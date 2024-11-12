class Solution {
    fun solution(park: Array<String>, routes: Array<String>): IntArray {
        var answer: IntArray = intArrayOf()
        var sX = 0
        var sY = 0
        
        for(i in park.indices) {
            for(j in park[i].indices) {
                if(park[i][j] == 'S') {
                    sX = i
                    sY = j
                }
            }
        }
        
        for(i in routes) {
            val (direction, move) = i.split(' ')
            var nX = sX
            var nY = sY
            var flag = 0
            
            for(j in 0 until move.toInt()) {
                when(direction) {
                    "E" -> {
                        nY++
                    }
                    "W" -> {
                        nY--
                    }
                    "S" -> {
                        nX++
                    }
                    "N" -> {
                        nX--
                    }
                }
                
                if (nX !in park.indices || nY !in park[0].indices || park[nX][nY] == 'X') {
                    flag = 1
                    break
                }
            }
            
            if(flag == 0) {
                sX = nX
                sY = nY
            }
        }
        
        return intArrayOf(sX, sY)
    }
}