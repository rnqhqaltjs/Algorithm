class Solution {
    fun solution(name: Array<String>, yearning: IntArray, photo: Array<Array<String>>): IntArray {
        var mapData: MutableMap<String, Int> = HashMap()
        var answer: IntArray = intArrayOf()
        
        for(i in name.indices) {
            mapData[name[i]] = yearning[i]
        }
        
        for(i in photo.indices) {
            var count = 0
            for(j in photo[i].indices) {
                count+= mapData.get(photo[i][j]) ?:0
            }
            answer+= count
            count = 0
        }
        
        return answer
    }
}