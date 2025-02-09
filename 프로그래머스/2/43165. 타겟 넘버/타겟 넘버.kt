class Solution {
    var answer = 0
    fun solution(numbers: IntArray, target: Int): Int {
        
        
        dfs(0, 0, numbers, target)
        return answer
    }
    
    fun dfs(num: Int, count: Int, number: IntArray, e: Int) {
        if(count == number.size) {
            if(num == e) {
                answer++
            }
        } else {
            dfs(num - number[count], count + 1, number, e)
            dfs(num + number[count], count + 1, number, e)
        } 
    }
}