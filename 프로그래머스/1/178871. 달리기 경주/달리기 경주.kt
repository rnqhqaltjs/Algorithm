class Solution {
    fun solution(players: Array<String>, callings: Array<String>): Array<String> {
        var answer: Array<String> = arrayOf<String>()
        val map = mutableMapOf<String, Int>()
        
        for(i in players.indices) {
            map[players[i]] = i
        }
        
        for(i in callings) {
            val index = map.getOrDefault(i, 0)
            val tmp = players[index -1]
            
            players[index - 1] = i
            players[index] = tmp
            
            map[i] = index -1
            map[tmp] = index
        }
        
        return players
    }
}