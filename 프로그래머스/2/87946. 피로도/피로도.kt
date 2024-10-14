class Solution {
    fun solution(k: Int, dungeons: Array<IntArray>): Int {
        var answer: Int = -1
        val visited = BooleanArray(dungeons.size)
        
        fun dfs(n: Int, count:Int) {
            answer = maxOf(answer, count)
            
            for(i in dungeons.indices) {
                if(!visited[i] && n>=dungeons[i][0]) {
                    visited[i] = true
                    dfs(n-dungeons[i][1], count + 1)
                    visited[i] = false
                }
            }
        }
                
        dfs(k, 0)
        
        return answer
    }
}