class Solution {
    fun solution(X: String, Y: String): String {
        var answer = StringBuilder()
        val map = mutableMapOf<Char,Int>()
        
        for(i in X) {
            map[i] = map.getOrDefault(i, 0) + 1
        }
        
        for(i in Y) {
            if(map.containsKey(i)) {
                map[i] = map.getOrDefault(i, 0) - 1
                if(map[i] == 0) {
                    map.remove(i)
                }
                answer.append(i)
            }
        }
        val result = answer.toString().toCharArray().sortedDescending().joinToString("")
        if (result.isEmpty()) return "-1"
        if (result.all { it == '0' }) return "0"

        return result
    }
}