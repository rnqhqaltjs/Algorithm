val words = arrayOf('A','E','I','O','U')
var answer = 0
var flag = false

class Solution {
    fun solution(word: String): Int {
        dfs("", word)
        return answer
    }
    
    fun dfs(s: String, e: String) {
        if(s == e) {
            flag = true
            return
        }
        
        if(s.length>=5) {
            return
        }
        
        for(i in words) {
            if(!flag) {
                dfs(s + i, e)
                answer++
            }
        }
    }
}