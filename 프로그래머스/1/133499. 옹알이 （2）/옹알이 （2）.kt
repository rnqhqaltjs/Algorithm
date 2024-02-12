class Solution {
    fun solution(babbling: Array<String>): Int {
        var answer: Int = 0
        
        
        for(i in babbling.indices) {
            if(babbling[i].contains("ayaaya") ||
               babbling[i].contains("yeye") ||
               babbling[i].contains("woowoo") ||
               babbling[i].contains("mama")) 
            {
                continue
            }
            babbling[i] = babbling[i].replace("aya", " ")
            babbling[i] = babbling[i].replace("ye", " ")
            babbling[i] = babbling[i].replace("woo", " ")
            babbling[i] = babbling[i].replace("ma", " ")
            babbling[i] = babbling[i].replace(" ", "")
            
            if (babbling[i].isEmpty()) answer++
        }
        return answer
    }
}