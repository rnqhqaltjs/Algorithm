class Solution {
    fun solution(scores: Array<IntArray>): Int {
        var answer: Int = 1
        val wanho = scores[0]
        val scores = scores.sortedWith(compareBy({ -it[0] }, { it[1] }))
        var max = 0

        for(i in scores) {
            if(max <= i[1]) {
                max = i[1]
                if(i.sum() > wanho.sum()) {
                    answer++
                }
            } else {
                if(i.equals(wanho)) {
                    return -1
                }
            }
        }
        
        return answer
    }
}