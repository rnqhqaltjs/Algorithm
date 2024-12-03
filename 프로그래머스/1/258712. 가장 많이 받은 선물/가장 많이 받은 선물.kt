class Solution {
    fun solution(friends: Array<String>, gifts: Array<String>): Int {
        var answer: Int = 0
        val giftMap = mutableMapOf<String, MutableMap<String, Int>>()
        val countMap = mutableMapOf<String, Int>()
        val takeMap = mutableMapOf<String, Int>()
        
        for(i in friends) {
            countMap[i] = 0
            giftMap[i] = mutableMapOf()
            for(j in friends) {
                if(i!=j) {
                    giftMap[i]!![j] = 0
                }
            } 
        }
        
        for(i in gifts) {
            val (give, take)  = i.split(" ")
            
            giftMap[give]!![take] = giftMap[give]!!.getOrDefault(take, 0) + 1
            countMap[give] = countMap.getOrDefault(give, 0) + 1
            countMap[take] = countMap.getOrDefault(take, 0) - 1 
        }
        
        for(i in friends) {
            for(j in friends) {
                if(i!=j) {
                    if(giftMap[i]!![j]!! > giftMap[j]!![i]!!) {
                        takeMap[i] = takeMap.getOrDefault(i, 0) + 1
                    } else if (giftMap[i]!![j]!! == giftMap[j]!![i]!!) {
                        if(countMap[i]!!>countMap[j]!!) {
                            takeMap[i] = takeMap.getOrDefault(i, 0) + 1
                        } else if(countMap[i]!!<countMap[j]!!) {
                            takeMap[j] = takeMap.getOrDefault(j, 0) + 1
                        }
                    } else {
                        takeMap[j] = takeMap.getOrDefault(j, 0) + 1
                    }
                }
            }
        }
        
        answer = takeMap.values.maxOrNull() ?: 0
        
        return answer / 2
    }
}