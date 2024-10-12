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
                
        fun dfs(s: Int, graph:Array<MutableList<Int>>, v:BooleanArray) {
            v[s] = true
            
            for(i in graph[s]) {
                if(!v[i]) {
                    dfs(i, graph, v)
                }
            }
        }
        
        for(i in 0 until n) {
            if(!visited[i]) {
                dfs(i, graph, visited)
                answer++
            }
        }
        return answer
    }
}