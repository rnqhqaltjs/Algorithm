class Solution {
    var answer: Int = 0
    
    fun solution(info: IntArray, edges: Array<IntArray>): Int {
        val visited = BooleanArray(info.size)

        dfs(0, 0, 0, info, edges, visited)
        return answer
    }
    
    fun dfs(s: Int, sheep: Int, wolf: Int, info: IntArray, edges: Array<IntArray>, visited: BooleanArray) {
        visited[s] = true
        
        var newSheep = sheep
        var newWolf = wolf
        
        if(info[s] == 0) {
            newSheep++
            answer = maxOf(answer, newSheep)
        } else {
            newWolf++
        }
        
        if(newSheep <= newWolf) {
            return
        }
        
        for(i in edges) {
            if(visited[i[0]] && !visited[i[1]]) {
                visited[i[1]] = true
                dfs(i[1], newSheep, newWolf, info, edges, visited)
                visited[i[1]] = false
            }
        }
    }
}