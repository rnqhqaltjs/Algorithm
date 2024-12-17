class Solution {
    fun solution(cards: IntArray): Int {
        var answer: Int = 0
        
        val map = mutableMapOf<Int,Pair<Int, Boolean>>()
        val resultList = mutableListOf<Int>()
        
        for(i in 1..cards.size) {
            map[i] = cards[i-1] to false
        }
        
        var start = 1
        var count = 0
        var groupCount = 0
        
        while(count<=cards.size + 1) {
            if(!map.getOrDefault(start, 0 to false).second) {
                map[start] = map.getOrDefault(start, 0 to false).first to true
                start = map.getOrDefault(start, 0 to false).first
                groupCount++
            } else {
                resultList.add(groupCount)
                groupCount = 0
                
                for((key, value) in map) {
                    if(!value.second) {
                        start = key
                    }
                }
            }
            
            count++
        }
        
        resultList.add(groupCount)
        resultList.sortDescending()
        
        
        println(map)
        println(resultList)
        return resultList[0] * resultList[1]
    }
}