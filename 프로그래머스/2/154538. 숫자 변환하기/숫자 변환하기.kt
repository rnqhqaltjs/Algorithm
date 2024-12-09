import java.util.* 

class Solution {
    fun solution(x: Int, y: Int, n: Int): Int {
        var answer: Int = 0
        val visited = BooleanArray(y+1)
        
        return bfs(x, y, n, visited)
    }
    
    fun bfs(s: Int, e:Int, n: Int, v: BooleanArray): Int {
        val q = LinkedList<Pair<Int, Int>>()
        v[s] = true
        q.offer(s to 0)
        
        while(q.isNotEmpty()) {
            val (c, count) = q.poll()
            
            if(c==e) {
                return count
            }
            
            if(c+n in v.indices && !v[c+n]) {
                v[c+n] = true
                q.offer(c+n to count + 1)
            }
            
            if(c * 2 in v.indices && !v[c*2]) {
                v[c*2] = true
                q.offer(c*2 to count + 1)
            }
            
            if(c * 3 in v.indices && !v[c*3]) {
                v[c*3] = true
                q.offer(c*3 to count + 1)
            }
        }
        
        return -1
    }
}