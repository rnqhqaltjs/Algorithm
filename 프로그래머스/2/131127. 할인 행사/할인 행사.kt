class Solution {
    fun solution(want: Array<String>, number: IntArray, discount: Array<String>): Int {
        var productMap: MutableMap<String,Int> = hashMapOf()
        var discountMap: MutableMap<String,Int> = hashMapOf()
        var answer: Int = 0
        
        
        for(i in want.indices) {
            productMap[want[i]] = number[i]
        }
        for(i in 0..discount.size-10) { 
            discountMap = hashMapOf()
            for(j in i until i+10) {
                discountMap[discount[j]] = discountMap.getOrDefault(discount[j], 0) + 1
            }
            if(productMap == discountMap) {
                answer++
            }
        }
        
        return answer
    }
}