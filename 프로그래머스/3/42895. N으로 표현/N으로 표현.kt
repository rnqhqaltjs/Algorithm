class Solution {
    var answer = Int.MAX_VALUE
    fun solution(N: Int, number: Int): Int {
        dfs(0, 0, number, N)
        return if (answer == Int.MAX_VALUE) -1 else answer
    }
    
    fun dfs(s: Int, depth: Int, e: Int, n: Int) {
        if(depth>9) {
            return
        }
        
        if(s == e) {
            answer = minOf(answer, depth)
            return
        }
        
        var next = n
        
        for(i in 1..8 - depth) {
            dfs(s + next, depth + i, e, n)
            dfs(s * next, depth + i, e, n)
            dfs(s - next, depth + i, e, n)
            dfs(s / next, depth + i, e, n)
            next += n * Math.pow(10.0, i.toDouble()).toInt()
        }
    }
}