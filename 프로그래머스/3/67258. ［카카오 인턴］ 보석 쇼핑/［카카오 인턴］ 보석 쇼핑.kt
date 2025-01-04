class Solution {
    fun solution(gems: Array<String>): IntArray {
        var answer = intArrayOf(1, gems.size)
        val map = mutableMapOf<String, Int>()
        
        var start = 0
        var end = 0
        
        var max = gems.toSet().size
        
        while(end < gems.size) {
            map[gems[end]] = map.getOrDefault(gems[end], 0) + 1
            end++
            
            while(map.size == max) {               
                map[gems[start]] = map.getOrDefault(gems[start], 0) - 1
                
                if(map[gems[start]] == 0) {
                    map.remove(gems[start])
                }
                
                start++
                
                if(end - start < answer[1] - answer[0]) {
                    answer = intArrayOf(start, end)
                }

            }
        }
        
        
        return answer
    }
}