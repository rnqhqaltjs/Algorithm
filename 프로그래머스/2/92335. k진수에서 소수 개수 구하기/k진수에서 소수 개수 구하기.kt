import kotlin.math.*

class Solution {
    fun solution(n: Int, k: Int): Int {
        var answer = 0
        val list = n.toString(k).split("0").filter { it.isNotEmpty() }

        println(list)
        
        for(i in list) {
            if(isPrime(i.toLong())) {
                answer++
            }
        }
        return answer
    }
    
    fun isPrime(n: Long): Boolean {
        
        if(n==1L) {
            return false
        }
        
        val sqrt = sqrt(n.toDouble()).toLong()
        
        for(i in 2..sqrt) {
            if(n%i==0L) {
                return false
            }
        }
        
        return true
    }
}