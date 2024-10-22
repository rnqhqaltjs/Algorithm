import java.util.*

class Solution {
    val dX = arrayOf(-1,0,1,0)
    val dY = arrayOf(0,1,0,-1)
    var startX = 0
    var startY = 0
    var endX = 0
    var endY = 0
    
    fun solution(board: Array<String>): Int {
        var answer: Int = 0
        val visited = Array(board.size) { BooleanArray(board[0].length) }
        
        for(i in board.indices) {
            for(j in board[0].indices) {
                if(board[i][j] == 'R') {
                    startX = i
                    startY = j
                } else if(board[i][j] == 'G') {
                    endX = i
                    endY = j
                }
            }
        }
        
        
        return bfs(startX, startY, board, visited)
    }
    
    fun bfs(sX: Int, sY: Int, board: Array<String>, v: Array<BooleanArray>): Int {
        val q = LinkedList<Triple<Int, Int, Int>>()
        v[sX][sY] = true
        q.add(Triple(sX, sY, 0))
        
        while(q.isNotEmpty()) {
            val (cX, cY, count) = q.poll()
            
            if(cX == endX && cY == endY) {
                return count
            }
            
            for(i in 0 until 4) {
                var nX = cX 
                var nY = cY
                
                while (nX + dX[i] in board.indices && nY + dY[i] in board[0].indices && board[nX + dX[i]][nY + dY[i]] != 'D') {
                    nX += dX[i]
                    nY += dY[i]
                }
                
                if(!v[nX][nY]) {
                    v[nX][nY] = true
                    q.add(Triple(nX, nY, count + 1))
                }
            }
        }
        return -1
    }
}