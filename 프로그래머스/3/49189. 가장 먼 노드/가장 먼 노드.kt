import java.util.*

class Solution {
    fun solution(n: Int, edge: Array<IntArray>): Int {
        val graph = Array(n + 1) { mutableListOf<Int>() }
        val distance = IntArray(n + 1) { -1 }
        
        for (e in edge) {
            graph[e[0]].add(e[1])
            graph[e[1]].add(e[0])
        }
        
        return bfs(1, graph, distance)
    }

    private fun bfs(s: Int, graph: Array<MutableList<Int>>, v: IntArray): Int {
        val q = LinkedList<Int>()
        q.add(s)
        v[s] = 0
        
        while(q.isNotEmpty()) {
            val c = q.poll()
            
            for(i in graph[c]) {
                if(v[i] == -1) {
                    q.add(i)
                    v[i] = v[c] + 1
                }
            }
        }
        
        var maxDistance = 0
        var count = 0

        for (i in v) {
            if (i > maxDistance) {
                maxDistance = i
                count = 1
            } else if (i == maxDistance) {
                count++
            }
        }
        
        return count
    }
}