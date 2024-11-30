class Solution {
    fun solution(name: Array<String>, yearning: IntArray, photo: Array<Array<String>>): IntArray {
        var answer = mutableListOf<Int>()
        val map = mutableMapOf<String, Int>()
        
        for(i in name.indices) {
            map[name[i]] = yearning[i]
        }
        
        for(i in photo.indices) {
            var sum = 0
            for(j in photo[i].indices) {
                sum+=map.getOrDefault(photo[i][j],0)
            }
            
            answer.add(sum)
        }
        return answer.toIntArray()
    }
}