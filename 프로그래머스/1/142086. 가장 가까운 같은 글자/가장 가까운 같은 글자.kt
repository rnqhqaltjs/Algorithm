class Solution {
    fun solution(s: String): IntArray {
        var answer = mutableListOf<Int>()
        val map = mutableMapOf<Char, Int>()
        
        for(i in s.indices) {
            if(!map.containsKey(s[i])) {
                map[s[i]] = i
                answer.add(-1)
            } else {
                answer.add(i - map.getOrDefault(s[i],0))
                map[s[i]] = i
            }
        }
        
        
        return answer.toIntArray()
    }
}