class Solution {
    fun solution(enroll: Array<String>, referral: Array<String>, seller: Array<String>, amount: IntArray): IntArray {
        var answer = IntArray(enroll.size)
        
        val edge = mutableMapOf<String, String>()
        val idxMap = mutableMapOf<String, Int>()
        
        for(i in enroll.indices) {
            edge[enroll[i]] = referral[i]
            idxMap[enroll[i]] = i
        }
        
        for(i in seller.indices) {
            var cost = amount[i] * 100
            var person = seller[i]
            
            while(person != "-") {
                if(cost / 10 == 0) {
                    answer[idxMap[person]!!] += cost
                    break
                } else {
                    var yourCost = cost / 10
                    var myCost = cost - yourCost
                    answer[idxMap[person]!!] += myCost
                
                    person = edge[person]!!
                    cost = yourCost    
                }
   
            }
        }
        
        return answer
    }
}