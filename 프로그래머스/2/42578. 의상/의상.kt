class Solution {
    fun solution(clothes: Array<Array<String>>): Int {
        var answer = 1
        
        val map = mutableMapOf<String, Int>()
        
        for(i in clothes) {
            map[i[1]] = map.getOrDefault(i[1], 0) + 1
        }
        
        for((key, value) in map) {
            answer*= (value + 1)
        }
        
        return answer - 1
    }
}