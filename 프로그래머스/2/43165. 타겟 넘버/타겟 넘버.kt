var answer = 0

class Solution {
    fun solution(numbers: IntArray, target: Int): Int {
        dfs(0, numbers, target, 0)
        
        return answer
    }
    
    fun dfs(count: Int, numbers: IntArray, target: Int, result: Int) {
        if(count == numbers.size) {
            if(result == target) {
                answer++
            }
        } else {
            dfs(count + 1, numbers, target, result + numbers[count])
            dfs(count + 1, numbers, target, result - numbers[count])
        }
    }
}