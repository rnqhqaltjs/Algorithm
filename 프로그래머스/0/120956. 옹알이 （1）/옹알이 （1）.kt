class Solution {
    fun solution(babbling: Array<String>): Int {
        var answer: Int = 0
        val mouth = arrayOf("aya","ye","woo","ma")
        
        for(i in babbling) {
            var babble = i
            
            for(j in mouth) {
                babble = babble.replace(j, " ")
            }
            
            babble = babble.replace(" ", "")
            if(babble == "") {
                answer++
            }   
        }
        return answer
    }
}