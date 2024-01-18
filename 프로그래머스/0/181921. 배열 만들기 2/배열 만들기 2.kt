class Solution {
    fun solution(l: Int, r: Int): IntArray {
        var answer: IntArray = intArrayOf()
        for(i in l..r) {
            val str = i.toString()
            var count = 0
            for(j in str.indices) {
               if(str[j].toString()=="5" || str[j].toString()=="0") {
                    count++
                } 
            }
            if(count == str.length) {
                answer+=i
            }
            count = 0
            
        }
        
        if(answer.size==0) {
            return intArrayOf(-1)
        } else {
            return answer
        }
        
    }
}