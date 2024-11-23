class Solution {
    fun solution(want: Array<String>, number: IntArray, discount: Array<String>): Int {
        var answer: Int = 0
        val wantMap = mutableMapOf<String, Int>()
         
        for(i in want.indices) {
            wantMap[want[i]] = number[i]
        }
        
        for(i in 0..discount.size - 10) {
            val discountMap = mutableMapOf<String, Int>()
            for(j in i until i + 10) {
                discountMap[discount[j]] = discountMap.getOrDefault(discount[j], 0) + 1
            }
            
            if(wantMap == discountMap) {
                answer++
            }
        }
        return answer
    }
}