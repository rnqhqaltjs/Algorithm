class Solution {
    fun solution(common: IntArray): Int {
        var answer: Int = 0
        if(common[2]-common[1]==common[1]-common[0]) {
            answer = common[common.size-1] + common[common.size-1] - common[common.size-2]
        } else {
            answer = common[common.size-1] * (common[common.size-1]/common[common.size-2])
        }
        return answer
    }
}