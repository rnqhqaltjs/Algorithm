class Solution {
    private lateinit var answer: MutableList<String>
    
    fun solution(tickets: Array<Array<String>>): Array<String> {
        answer = mutableListOf()
        tickets.sortWith(compareBy({ it[0] }, { it[1] }))
        val visited = BooleanArray(tickets.size)
        
        dfs("ICN", tickets, visited, mutableListOf("ICN"), 0)
        return answer.toTypedArray()
    }
    
    fun dfs(s: String, graph: Array<Array<String>>, v: BooleanArray, path: MutableList<String>, count: Int) {
        if(count == graph.size && answer.isEmpty()) {
            answer = path.toMutableList()
            return
        }
        
        for(i in graph.indices) {
            if(!v[i] && graph[i][0] == s) {
                path.add(graph[i][1])
                v[i] = true
                dfs(graph[i][1], graph, v, path, count + 1)
                path.removeLast()
                v[i] = false
            }
        }
    }
}