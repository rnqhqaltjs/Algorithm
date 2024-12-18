class Solution {
    fun solution(genres: Array<String>, plays: IntArray): IntArray {
        var answer = mutableListOf<Int>()
        var playGenresMap = mutableMapOf<String, Int>()
        var playsMap = mutableMapOf<String, MutableList<Pair<Int, Int>>>()
        
        for(i in genres.indices) {
            playGenresMap[genres[i]] = playGenresMap.getOrDefault(genres[i], 0) + plays[i]
            playsMap.getOrPut(genres[i]) { mutableListOf() }.add(i to plays[i])
        }
        
        playGenresMap = playGenresMap.toList().sortedByDescending { it.second }.toMap().toMutableMap()
        
        for((key, value) in playsMap) {
            value.sortByDescending { it.second }
        }
        
        val sortedPlaysMap = playGenresMap.keys.associateWith { playsMap[it] }
        
        println(sortedPlaysMap)
        
        for((key, value) in sortedPlaysMap) {
            var count = 0
            if(value!=null) {
                for(i in value) {
                    answer.add(i.first)
                    count++
                    
                    if(count == 2) {
                        count = 0
                        break
                    }
                }
            }
        }
        
        return answer.toIntArray()
    }
}