class Solution {
    fun solution(sequence: IntArray, k: Int): IntArray {
        var answer: IntArray = intArrayOf(0, 10000001)
        
        var start = 0
        var end = 0
        var sum = sequence[0]
        while(end<sequence.size) {
            if(sum<k) {
                end++
                if(end < sequence.size) sum += sequence[end]
            }
            else if(sum > k) {
                sum-=sequence[start]
                start++
            }
            else {
                if(answer[1]-answer[0] > end - start){
                    answer = intArrayOf(start, end)
                }
                sum-=sequence[start]
                start++
            }
        }
        return answer
    }
}