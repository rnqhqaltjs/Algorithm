class Solution {
    fun solution(keymap: Array<String>, targets: Array<String>): IntArray {
        var answer = IntArray(targets.size)
        val map = mutableMapOf<Char,Int>()
        
        for(i in keymap.indices) {
            for(j in keymap[i].indices) {
                val key = keymap[i][j]
                val value = map.getOrDefault(key, j + 1)
                
                map[key] = minOf(value, j + 1)
            }
        }
        
        for(i in targets.indices) {
            for(j in targets[i].indices) {
                val key = targets[i][j]
                if(map.containsKey(key)) {
                    answer[i] +=map[key]!!
                } else {
                    answer[i] = -1
                    break
                }
            }
        }
        return answer
    }
}