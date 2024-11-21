class Solution {
    fun solution(targets: Array<IntArray>): Int {
        var answer: Int = 0
        var sortedTargets = targets.sortedWith(compareBy({it[1]}, {it[0]}))
        
        var e = 0
        for(i in sortedTargets) {
            if(i[0]>=e) {
                answer++
                e = i[1]
            }
        }
        return answer
    }
}