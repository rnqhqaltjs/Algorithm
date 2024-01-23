class Solution {
    fun solution(num: Int, total: Int): IntArray {
        var answer: IntArray = intArrayOf()
        var data = total/num
        var startNum = data - (num-1)/2
        
        
        for(i in 0..num-1) {
            answer+=startNum+i
        }
        return answer
    }
}