import java.util.*

val dX = intArrayOf(-1, 0, 1, 0)
val dY = intArrayOf(0, 1, 0, -1)

data class Route(
    val cX: Int,
    val cY: Int,
    val direction: Int,
    var count: Int = 0
)

class Solution {
    fun solution(board: Array<IntArray>): Int {
        val visited = Array(board.size) { Array(board[0].size) { IntArray (4) { Int.MAX_VALUE } } }
        
        return bfs(0, 0, board, visited)
    }
    
    fun bfs(sX: Int, sY: Int, board: Array<IntArray>, v: Array<Array<IntArray>>): Int {
        val q = LinkedList<Route>()
        q.offer(Route(sX, sY, -1, 0))
        
        while(q.isNotEmpty()) {
            val (cX, cY, direction, count) = q.poll()
            
            for(i in 0 until 4) {
                val nX = cX + dX[i]
                val nY = cY + dY[i]
                
                val next = if(direction == -1 || direction == i) {
                    count + 100
                } else {
                    count + 600
                }
                
                if(nX in board.indices && nY in board[0].indices) {
                    if(v[nX][nY][i] >= next && board[nX][nY] == 0) {
                        q.offer(Route(nX, nY, i, next))
                        v[nX][nY][i] = next
                    }
                }
            }
        }
        
        return v[board.size - 1][board.size - 1].minOrNull()!!
    }
}