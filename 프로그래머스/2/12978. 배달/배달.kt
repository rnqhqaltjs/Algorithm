import java.util.*

class Solution {
    fun solution(N: Int, road: Array<IntArray>, k: Int): Int {
        val graph = Array(N+1) { mutableListOf<Pair<Int, Int>>() }

        for(i in road) {
            val (a,b,c) = i
            graph[a].add(b to c)
            graph[b].add(a to c)
        }
        
        return bfs(1, graph, N, k)
    }
    
    fun bfs(s: Int, graph: Array<MutableList<Pair<Int,Int>>>, n: Int, k: Int): Int {
        val dist = IntArray(n+1) { Int.MAX_VALUE }
        dist[s] = 0
        val pq = PriorityQueue<Pair<Int, Int>>(compareBy{it.second})
        pq.add(s to 0)
        
        while(pq.isNotEmpty()) {
            val (current, currentDist) = pq.poll()
            
            for((next, time) in graph[current]) {
                val newDist = currentDist + time
                if(newDist< dist[next]) {
                    dist[next] = newDist
                    pq.add(next to newDist)
                }
            }
        }
        
        return dist.count{it<=k}
    }
}