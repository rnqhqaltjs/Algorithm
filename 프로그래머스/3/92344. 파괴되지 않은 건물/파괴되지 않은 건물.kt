class Solution {
    fun solution(board: Array<IntArray>, skill: Array<IntArray>): Int {
        var answer: Int = 0
        var N = board.size
        var M = board[0].size
        
        val prefixSum = Array(N + 1) { IntArray(M + 1) { 0 } }
        for (s in skill) {
            val type = s[0]
            val r1 = s[1]
            val c1 = s[2]
            val r2 = s[3]
            val c2 = s[4]
            val degree = if (type == 1) -s[5] else s[5]

            prefixSum[r1][c1] += degree
            prefixSum[r1][c2 + 1] -= degree
            prefixSum[r2 + 1][c1] -= degree
            prefixSum[r2 + 1][c2 + 1] += degree
        }
         
        for(i in 0..N) {
            for(j in 0 until M) {
              prefixSum[i][j + 1] += prefixSum[i][j]  
            }
        }
        
        for(i in 0..M) {
            for(j in 0 until N) {
                prefixSum[j + 1][i] += prefixSum[j][i]
            }
        }

        for (i in 0 until N) {
            for (j in 0 until M) {
                if (board[i][j] + prefixSum[i][j] > 0) answer++
            }
        }
        return answer
    }
}