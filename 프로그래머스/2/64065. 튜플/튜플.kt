class Solution {
    fun solution(s: String): IntArray {
        var answer = mutableListOf<Int>()
        var map = mutableMapOf<String, Int>()
        var s = s.replace("{", "").replace("}","").split(",")
        
        for(i in s) {
            map[i] = map.getOrDefault(i, 0) + 1
        }
        
        println(map.toList())
        
        map = map.toList().sortedByDescending { it.second }.toMap().toMutableMap()
        
        for((key, value) in map) {
            answer.add(key.toInt())
        }
        
        
        return answer.toIntArray()
    }
}