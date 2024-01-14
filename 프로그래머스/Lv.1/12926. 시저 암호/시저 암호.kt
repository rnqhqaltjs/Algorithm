class Solution {
    fun solution(s: String, n: Int): String {
        var answer=""
        for(i in s.indices) {
            if(s[i].isUpperCase()) {
                answer += ((s[i] - 'A' + n) % 26 + 'A'.toInt()).toChar()
            } 
            else if(s[i].isLowerCase()){
                answer += ((s[i] - 'a' + n) % 26 + 'a'.toInt()).toChar()
            }
            else {
                answer+=s[i]
            }
            
        }
        return answer
    }
}