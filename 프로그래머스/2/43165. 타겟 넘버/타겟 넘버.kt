class Solution {
    fun solution(numbers: IntArray, target: Int): Int {
        var answer = 0
        
        fun dfs(count: Int, result: Int) {
            if(numbers.size==count) {
                if(target==result) {
                    answer++
                }
            } else {
                dfs(count+1, result+numbers[count])
                dfs(count+1, result-numbers[count])
            }
        }
        
        dfs(0,0)
        
        return answer
    }
}