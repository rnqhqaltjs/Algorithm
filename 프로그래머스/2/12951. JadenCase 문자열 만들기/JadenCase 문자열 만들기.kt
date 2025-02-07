class Solution {
    fun solution(s: String): String {
        var answer = ""
        
        var list = s.split(" ")
        var newList = mutableListOf<String>()

        
        for(i in list) {
            var newStr = ""
            for(j in i) {
                newStr += j.toLowerCase()
            }
            newList.add(newStr)
        }
        
        for(i in newList) {
            for(j in i.indices) {
                if(j == 0) {
                    answer += i[j].toUpperCase()
                } else {
                    answer += i[j]
                }
            }
            answer += " "
        }
        
        println(newList)
        return answer.substring(0, answer.length - 1)
    }
}