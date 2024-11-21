class Solution {
    fun solution(s: String): String {
        var answer = ""
        var lc = s.toLowerCase().split(" ")
        
        for(i in lc) {
            for(j in i.indices) {
                if(j==0) {
                    answer+=i[j].toUpperCase()
                } else {
                    answer+=i[j]
                }
            } 
            answer+=" "
        }
        
        answer = answer.substring(0, answer.length-1)
        return answer
    }
}