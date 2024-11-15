import java.util.*

val dX = arrayOf(-1,0,1,0)
val dY = arrayOf(0,1,0,-1)

class Solution {
    fun solution(places: Array<Array<String>>): IntArray {
        var answer = mutableListOf<Int>()
        
        for(i in places) {
            val result = check(i)
            answer.add(result)
        }
        
        return answer.toIntArray()
    }
    
    fun check(place: Array<String>): Int {
        for (i in place.indices) {
            for (j in place[i].indices) {
                if (place[i][j] == 'P') {
                    if (!bfs(i, j, place)) {
                        return 0
                    }
                }
            }
        }
        return 1
    }
    
    fun bfs(sX: Int, sY:Int, place: Array<String>): Boolean {
        val q = LinkedList<Pair<Int,Int>>()
        q.offer(sX to sY)
        val board = Array(5) { IntArray(5) { 0 } }
        
        while(q.isNotEmpty()) {
            val (cX, cY)  = q.poll()
            var distance = board[cX][cY] + 1
            
            if(distance>2) {
                return true
            }
            
            for(i in 0 until 4) {
                val nX = cX + dX[i]
                val nY = cY + dY[i]
                
                if (nX == sX && nY == sY) { continue } 
                
                if((nX in place.indices && nY in place[0].indices)) {
                    if(place[nX][nY] != 'X' && board[nX][nY] ==0) {
                        q.add(nX to nY)
                        board[nX][nY] = distance
                    }
                    
                    if(place[nX][nY] == 'P' && board[nX][nY] <= 2) {
                        return false
                    }
                }
            }
        }
        
        return true
    }
}