class Solution {
    fun solution(orders: Array<String>, course: IntArray): Array<String> {
        var answer = mutableListOf<String>()
        val map = mutableMapOf<String, Int>()
        
        for(i in orders) {
            val order = i.toCharArray().sorted().joinToString("") 
            for(j in course) {
                dfs("", order, j, map, 0)
            }
        }
        
        for(i in course) {
            var max = 0
            
            for(entry in map) {
                if(entry.key.length == i) {
                    max = maxOf(max, entry.value)
                }
            }
            
            for(entry in map) {
                if(entry.key.length == i && entry.value == max && entry.value>=2) {
                    answer.add(entry.key)
                }
            }
        }
        return answer.sorted().toTypedArray()
    }
    
    fun dfs(s: String, order: String, course: Int, map: MutableMap<String, Int>, index: Int) {
        if(s.length == course) {
            map[s] = map.getOrDefault(s, 0) + 1
            return
        }
        for (i in index until order.length) {
            dfs(s + order[i], order, course, map, i + 1)
        }
    }
}