class Solution {
    fun solution(s: String): IntArray {
        val answer = IntArray(s.length)
        val map = mutableMapOf<Char, Int>()
        
        for(i in s.indices) {
            if(!map.containsKey(s[i])) {
                answer[i] = -1
                map[s[i]] = i
            } else {
                answer[i] = i - map[s[i]]!!
                map[s[i]] = i
            }
        }
        return answer
    }
}