class Solution {
    fun solution(begin: String, target: String, words: Array<String>): Int {
        var answer = Int.MAX_VALUE
        val visited = BooleanArray(words.size)
        
        if(target !in words) {
            answer = 0
        }
        fun dfs(s: String, e: String, count: Int, word: Array<String>){
            
            if(s == e) {
                answer = minOf(answer, count)
                return
            }
            
            for(i in word.indices) {
                var wrong = 0
                for(j in s.indices) {
                    if(s[j] != word[i][j]) {
                        wrong++
                    }
                }
                
                if(!visited[i] && wrong==1) {
                    visited[i] = true
                    dfs(word[i], e, count + 1, word)
                    visited[i] = false
                }
            }
        }
        
        dfs(begin, target, 0, words)
        return answer
    }
}