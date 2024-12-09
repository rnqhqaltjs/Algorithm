import kotlin.math.*

class Solution {
    var answer = mutableSetOf<Int>()
    
    fun solution(numbers: String): Int {
        val visited = BooleanArray(numbers.length)
        
        dfs("", numbers, visited)
        return answer.size
    }
    
    fun dfs(s: String, numbers: String, v: BooleanArray) {
        if(s != "" && isPrime(s.toInt())) {
            answer.add(s.toInt())
        }
        
        for(i in numbers.indices) {
            if(!v[i]) {
                val c = s+numbers[i].toString()
                
                v[i] = true
                dfs(c, numbers, v)
                v[i] = false
            }
        }
    }
    
    fun isPrime(x: Int): Boolean {
        if(x<2) {
            return false
        }
        
        for(i in 2..sqrt(x.toDouble()).toInt()) {
            if(x%i==0) {
                return false
            }
        }
        
        return true
    }
}