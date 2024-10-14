import java.util.*

val dX = arrayOf(-1,0,1,0)
val dY = arrayOf(0,1,0,-1)

class Solution {
    fun solution(maps: Array<String>): Int {
        var answer: Int = 0
        var visited = Array(maps.size) {BooleanArray(maps[0].length)}
        var startI = 0
        var startJ = 0
        var leverI = 0
        var leverJ = 0
        var endI = 0
        var endJ = 0
        
        for (i in maps.indices) {
            for (j in maps[0].indices) {
                if (maps[i][j] == 'S') {
                    startI = i
                    startJ = j
                }
                else if (maps[i][j] == 'E') {
                    endI = i
                    endJ = j
                }
                else if (maps[i][j] == 'L') {
                    leverI = i
                    leverJ = j
                }
            }
        }
        
        val a = bfs(startI, startJ, leverI, leverJ, maps, visited)
        visited = Array(maps.size) {BooleanArray(maps[0].length)}
        val b = bfs(leverI, leverJ, endI, endJ, maps, visited)
        
        if(a==-1 || b==-1) {
            return -1
        } else {
            return a+b
        }
    }
    
    fun bfs(sX: Int, sY: Int, eX:Int, eY: Int, graph: Array<String>, v: Array<BooleanArray>): Int {
        val q = LinkedList<Triple<Int,Int,Int>>()
        v[sX][sY] = true
        q.offer(Triple(sX, sY, 0))
        
        while(q.isNotEmpty()) {
            val (cX, cY, count)  = q.poll()
            
            if(cX == eX && cY == eY) {
                return count
            }
            
            for(i in 0 until 4) {
                val nX = cX + dX[i]
                val nY = cY + dY[i]
                
                if(nX in graph.indices && nY in graph[0].indices) {
                    if(!v[nX][nY] && graph[nX][nY] != 'X') {
                        v[nX][nY] = true
                        q.offer(Triple(nX, nY, count + 1))
                    }
                }
            }
        }
        
        return -1
    }
}