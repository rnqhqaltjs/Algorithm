class Solution {
    val answer = mutableSetOf<Int>()
    fun solution(numbers: String): Int {
        val visited = BooleanArray(numbers.length)
        for(i in numbers.indices) {
            visited[i] = true
            dfs(numbers[i].toString().toInt(), numbers, visited)
            visited[i] = false
        }
        return answer.size
    }
    
    fun dfs(s: Int, nums: String, v: BooleanArray) {
        if(isPrime(s)) {
            answer.add(s)
        }
        
        for(i in nums.indices) {          
            if(!v[i]) {
                val c = s.toString() + nums[i].toString()
                v[i] = true
                dfs(c.toInt(), nums, v)
                v[i] = false
            }
        }
    }
    
    fun isPrime(x: Int): Boolean {
        if (x < 2) {
            return false
        }
        for (i in 2..Math.sqrt(x.toDouble()).toInt()) {
            if (x % i == 0) {
                return false
            }
        }
        return true
    }
}