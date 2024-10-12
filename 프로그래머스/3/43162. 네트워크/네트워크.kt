import java.util.LinkedList

class Solution {
    fun solution(n: Int, computers: Array<IntArray>): Int {
        var answer = 0
        val visited = BooleanArray(n)
        val graph = Array(n) { mutableListOf<Int>() }
        
        for(i in 0 until n) {
            for(j in 0 until n) {
                if(i!=j && computers[i][j] == 1) {
                    graph[i].add(j)
                }
            }
        }
                
        fun bfs(s: Int, graph:Array<MutableList<Int>>, v:BooleanArray) {
            v[s] = true
            val q = LinkedList<Int>()
            q.offer(s)
            
            while(q.isNotEmpty()) {
                val c = q.poll()
                
                for(i in graph[c]) {
                    if(!visited[i]) {
                        q.offer(i)
                        v[i] = true
                    }
                }
            }
        }
        
        for(i in 0 until n) {
            if(!visited[i]) {
                bfs(i, graph, visited)
                answer++
            }
        }
        return answer
    }
}