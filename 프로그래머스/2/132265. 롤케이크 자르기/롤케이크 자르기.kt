class Solution {
    fun solution(topping: IntArray): Int {
        var answer: Int = 0
        val map1 = mutableMapOf<Int, Int>()
        val map2 = mutableMapOf<Int, Int>()
        
        for(i in topping) {
            map1[i] = map1.getOrDefault(i, 0) + 1
        }
        
        for(i in topping) {
            map1[i] = map1.getOrDefault(i, 0) - 1
            
            if(map1[i] == 0) {
                map1.remove(i)
            }
            
            map2[i] = map2.getOrDefault(i, 0) + 1
            
            if(map1.size == map2.size) {
                answer++
            }
        }
        return answer
    }
}