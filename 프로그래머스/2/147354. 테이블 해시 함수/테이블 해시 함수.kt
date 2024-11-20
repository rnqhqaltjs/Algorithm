class Solution {
    fun solution(data: Array<IntArray>, col: Int, row_begin: Int, row_end: Int): Int {
        val sortedData = data.sortedWith(compareBy({ it[col-1] } , { -it[0] }))
        var answer = 0
        
        for(i in row_begin..row_end) {
            var sum = 0
            for(j in sortedData[i-1].indices) {
                sum += sortedData[i-1][j] % i 
            }
            answer = answer xor sum
        }
        
        return answer
    }
}