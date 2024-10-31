class Solution {
    fun solution(orders: Array<String>, course: IntArray): Array<String> {
        var answer = mutableListOf<String>()
        val map = mutableMapOf<String, Int>()
        
        for(i in orders) {
            val order = i.toCharArray().sorted().joinToString("") 
            val visited = BooleanArray(order.length)
            for(j in course) {
                dfs("", order, j, map, visited, 0)
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
    
    fun dfs(s: String, order: String, course: Int, map: MutableMap<String, Int>, v: BooleanArray, index: Int) {
        if(s.length == course) {
            map[s] = map.getOrDefault(s, 0) + 1
            return
        }
        for (i in index until order.length) {
            if (!v[i]) {
                v[i] = true
                dfs(s + order[i], order, course, map, v, i + 1)
                v[i] = false
            }
        }
    }
}