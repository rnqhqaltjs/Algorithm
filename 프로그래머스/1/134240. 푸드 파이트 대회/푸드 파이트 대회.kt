class Solution {
    fun solution(food: IntArray): String {
        var answer = "0"
        
        for(i in food.size - 1 downTo 1) {
            for(j in 1..food[i]/2) {
                answer = i.toString() + answer
                answer = answer + i.toString()
            }
        }
        return answer
    }
}