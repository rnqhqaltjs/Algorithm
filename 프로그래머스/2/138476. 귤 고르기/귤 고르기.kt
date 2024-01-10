class Solution {
    fun solution(k: Int, tangerine: IntArray): Int {
        var list = hashMapOf<Int, Int>()
        var answer = intArrayOf()
        var k = k
        var count = 0
        
        for(i in tangerine) {
            list[i] = list.getOrDefault(i, 0) + 1
        }
        answer = list.values.sortedDescending().toIntArray()
        
        for(i in answer) {
            count ++
            k-=i
            if(k<=0) {
                break
            }    
        }
        return count
    }
}