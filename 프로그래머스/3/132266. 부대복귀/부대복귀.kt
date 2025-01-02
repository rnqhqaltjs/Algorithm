import java.util.*

class Solution {
    fun solution(n: Int, roads: Array<IntArray>, sources: IntArray, destination: Int): IntArray {
        var answer = mutableListOf<Int>()
        val graph = Array(n + 1) { mutableListOf<Int>() }
        val visited = IntArray(n + 1) { -1 }
        
        for(i in roads) {
            graph[i[0]].add(i[1])
            graph[i[1]].add(i[0])
        }
        
        bfs(destination, graph, visited)
        
        for(i in sources) {
            answer.add(visited[i])
        }
        
        return answer.toIntArray()
    }
    
    fun bfs(s: Int, graph: Array<MutableList<Int>>, v: IntArray) {
        val q = LinkedList<Int>()
        q.offer(s)
        v[s] = 0
        
        while(q.isNotEmpty()) {
            val c = q.poll()
            
            for(i in graph[c]) {
                if(v[i] == -1) {
                    q.offer(i)
                    v[i] = v[c] + 1
                }
            }
        }
    }
}