import kotlin.math.*

class Solution {
    fun solution(n: Int, wires: Array<IntArray>): Int {
        var min = Int.MAX_VALUE
        val graph = Array(n+1) { mutableListOf<Int>() }
        for(i in wires){
            graph[i[0]].add(i[1])
            graph[i[1]].add(i[0])
        }
        
        for(i in wires) {
            val visited = BooleanArray(n+1)
            
            graph[i[0]].remove(i[1])
            graph[i[1]].remove(i[0])
            
            val count = dfs(1, graph, visited)
            min = minOf(min, abs(count - (n-count)))
            
            graph[i[0]].add(i[1])
            graph[i[1]].add(i[0])
        }
        return min
    }
    
    fun dfs(c: Int, graph: Array<MutableList<Int>>, v: BooleanArray): Int {
        v[c] = true
        var count = 1
        
        for(i in graph[c]) {
            if(!v[i]) {
                count+= dfs(i, graph, v)
            }
        }
        return count
    }
}