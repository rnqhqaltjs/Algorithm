class Solution {
    var answer: Int = -1
    
    fun solution(k: Int, dungeons: Array<IntArray>): Int {
        val visited = BooleanArray(dungeons.size)
        dfs(k, dungeons, visited, 0)
        
        return answer
    }
    
    fun dfs(s: Int, dungeons: Array<IntArray>, v: BooleanArray, count: Int) {
        answer = maxOf(answer, count)
        
        for(i in dungeons.indices) {
            if(s>=dungeons[i][0] && !v[i]) {
                v[i] = true
                dfs(s - dungeons[i][1], dungeons, v, count + 1)
                v[i] = false
            }
        }
    }
}