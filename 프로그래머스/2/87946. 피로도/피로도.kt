class Solution {
    var answer: Int = 0
    fun solution(k: Int, dungeons: Array<IntArray>): Int {
        val visited = BooleanArray(dungeons.size)
        
        dfs(k, dungeons, visited, 0)
        return answer
    }
    
    fun dfs(s: Int, dungeon: Array<IntArray>, v: BooleanArray, count: Int) {
        answer = maxOf(count, answer)
        
        for(i in dungeon.indices) {
            if(s>=dungeon[i][0] && !v[i]) {
                v[i] = true
                dfs(s - dungeon[i][1], dungeon, v, count + 1)
                v[i] = false
            }
        }
    }
}