class Solution {
    fun solution(rank: IntArray, attendance: BooleanArray): Int {
        var answer: Int = 0
        var hash : MutableMap<Int,Boolean> = hashMapOf()
        
        for(i in rank.indices) {
            if(attendance[i]==true) {
                hash.put(rank[i],attendance[i])
            }
        }
        
        val sortedKeys = hash.keys.sorted()
        
        if (sortedKeys.size >= 3) {
            answer += rank.indexOf(sortedKeys[0]) * 10000 + rank.indexOf(sortedKeys[1]) * 100 + rank.indexOf(sortedKeys[2])
        }
        
        return answer
    }
}