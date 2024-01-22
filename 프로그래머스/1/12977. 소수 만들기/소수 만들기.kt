class Solution {
    fun isPrime(num: Int): Boolean {
        if (num <= 1) return false 
        return (2..Math.sqrt(num.toDouble()).toInt()).none { num % it == 0 }
    }
    
    fun solution(nums: IntArray): Int {
        var answer = 0
 
        for(i in 0..nums.size-1) {
            for(j in i+1..nums.size-1) {
                for(k in j+1..nums.size-1) {
                    if(isPrime(nums[i]+nums[j]+nums[k])) {
                        answer++
                    }
                }
            }
        }
        return answer
    }
}