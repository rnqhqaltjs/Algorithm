class Solution {
    fun solution(food: IntArray): String {
        var answer: String = ""
        for(i in 1 until food.size) {
            for (j in 1..food[i]/2) {
                answer+=i
            }
        }

        
        return answer+ 0*food[0] + answer.reversed()
    }
}