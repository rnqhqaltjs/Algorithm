class Solution {
    fun isPrime(num: Long): Boolean {
        if (num <= 1) return false 
        return (2..Math.sqrt(num.toDouble()).toLong()).none { num % it == 0L }
    }
    
    fun solution(n: Int, k: Int): Int {
        var answer: Int = 0
        var list = n.toString(k).split("0").filter{it.isNotEmpty()}.map{it.toLong()}
        for(i in list) {
            if(isPrime(i)) {
                answer++
            }
        }
        return answer
    }
}