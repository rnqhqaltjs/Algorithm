class Solution {
    fun solution(cards1: Array<String>, cards2: Array<String>, goal: Array<String>): String {
        var answer = "Yes"
        var idx1 = 0
        var idx2 = 0
        
        for(i in goal) {
            if(idx1< cards1.size && i == cards1[idx1]) {
                idx1++
            } else if (idx2 < cards2.size && i == cards2[idx2]) {
                idx2++
            } else {
                answer = "No"
            }
        }

        return answer
    }
}