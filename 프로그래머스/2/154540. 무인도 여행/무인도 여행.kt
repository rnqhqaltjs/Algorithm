import java.util.*

class Solution {
    val dX = arrayOf(-1,0,1,0)
    val dY = arrayOf(0,1,0,-1)
    var answer = mutableListOf<Int>()
    fun solution(maps: Array<String>): IntArray {
        val visited = Array(maps.size) { BooleanArray(maps[0].length) }
        
        for (i in maps.indices) {
            for(j in maps[0].indices) {
                if(!visited[i][j] && maps[i][j] != 'X') {
                    bfs(i,j, maps, visited)
                }
            }
        }
        return if(answer.isEmpty()) intArrayOf(-1) else answer.sorted().toIntArray()
    }
    
    fun bfs(sX: Int, sY: Int, maps: Array<String>, v:Array<BooleanArray>) {
        val q = LinkedList<Pair<Int,Int>>()
        v[sX][sY] = true
        q.add(sX to sY)
        var count = maps[sX][sY].digitToInt()
        
        while(q.isNotEmpty()) {
            val (cX, cY) = q.poll()
            
            for(i in 0 until 4) {
                val nX = cX + dX[i]
                val nY = cY + dY[i]
                
                if(nX in maps.indices && nY in maps[0].indices) {
                    if(!v[nX][nY] && maps[nX][nY] != 'X') {
                        q.add(nX to nY)
                        v[nX][nY] = true
                        count += maps[nX][nY].digitToInt()
                    }
                }
            }
        }
        answer.add(count)
    }
}