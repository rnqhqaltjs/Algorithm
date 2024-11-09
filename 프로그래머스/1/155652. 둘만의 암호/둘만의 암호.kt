class Solution {
    fun solution(s: String, skip: String, index: Int): String {
        var answer: String = ""
        
        
        for(i in s) {
            var word = i
            for(j in 0 until index) {
                if(word == 'z') {
                    word = 'a'
                } else {
                    word += 1
                }
                
                
                while(skip.contains(word)) {
                    if(word == 'z') {
                        word = 'a'
                    } else {
                        word += 1
                    }
                }
            }
            answer += word
        }
        
        return answer
    }
}