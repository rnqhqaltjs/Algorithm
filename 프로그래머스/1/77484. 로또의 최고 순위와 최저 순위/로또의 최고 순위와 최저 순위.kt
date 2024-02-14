class Solution {
    fun solution(lottos: IntArray, win_nums: IntArray): IntArray {
        var answer: IntArray = intArrayOf()
        var count = 0
        var iCount = 0
        for(i in lottos) {
            if(win_nums.contains(i)) {
                count++
            }
            if(i==0) {
                iCount++
            }
        }
        if(count!=0) {
            answer+=7-count-iCount
            answer+=7-count
        } else if(count==0 && iCount==0) {
            answer+=6-count-iCount
            answer+=6-count
        } else {
            answer+=7-count-iCount
            answer+=6-count
        }
        
        return answer
    }
}