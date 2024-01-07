class Solution {
    fun solution(cipher: String, code: Int): String {
        var answer: String = ""
        for(i in code..cipher.length step(code)) {
            answer+=cipher[i-1]
            
        }
        return answer
    }
}