class Solution {
    fun solution(n: Int, results: Array<IntArray>): Int {
        val winners = Array(n + 1) { mutableListOf<Int>() }
        val losers = Array(n + 1) { mutableListOf<Int>() }

        for(result in results) {
            val (winner, loser) = result
            
            winners[winner].add(loser)
            losers[loser].add(winner)
        }
        
        var answer = 0
        
        for(i in 1..n) {        
            val visitedWins = BooleanArray(n + 1)
            val visitedLosses = BooleanArray(n + 1)
        
            val winCount = dfs(i, winners, visitedWins)
            val loseCount = dfs(i, losers, visitedLosses)
            
            if(winCount + loseCount == n - 1) {
                answer++
            }
        }
          
        return answer
    }
    
    fun dfs(s: Int, graph: Array<MutableList<Int>>, v: BooleanArray): Int {
        v[s] = true
        var count = 0
        
        for(i in graph[s]) {
            if(!v[i]) {
                count += 1 + dfs(i, graph, v)
            }
        }
        
        return count
    }
}