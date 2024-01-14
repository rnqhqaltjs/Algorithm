class Solution {
    fun solution(s: String): String {
        var list = s.split(" ")
        var answer = ""
        for(i in list) {
            for(j in i.indices) {
                if(j%2==0) {
                    answer+=i[j].toUpperCase()
                } else {
                    answer+=i[j].toLowerCase()
                } 
            }
            answer+=" "
        }
        
        
        
        return answer.substring(0, answer.length - 1)
    }
}