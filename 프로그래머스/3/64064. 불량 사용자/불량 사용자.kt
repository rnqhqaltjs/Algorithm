class Solution {
    val answer = mutableSetOf<String>()
    
    fun solution(user_id: Array<String>, banned_id: Array<String>): Int {
        val visited = BooleanArray(user_id.size)
        
        dfs(0, banned_id.size, visited, user_id, banned_id, mutableSetOf<String>())
        return answer.size
    }
    
    fun dfs(depth: Int, target: Int, v: BooleanArray, user_id: Array<String>, banned_id: Array<String>, banned_list: MutableSet<String>) {
        if(depth == target) {
            answer.add(banned_list.sorted().joinToString(","))
            return
        }
        
        for(i in user_id.indices) {
            if(!v[i] && check(user_id[i], banned_id[depth])) {
                v[i] = true
                banned_list.add(user_id[i])
                dfs(depth + 1, target, v, user_id, banned_id, banned_list)
                banned_list.remove(user_id[i])
                v[i] = false
            }
        }
    }
    
    fun check(user: String, banned: String): Boolean {
        if(user.length != banned.length) {
            return false
        }
        
        for(i in user.indices) {
            if(user[i] != banned[i] && banned[i] != '*') {
                return false
            }
        }
        
        return true
    }
}