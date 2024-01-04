class Solution {
    fun solution(price: Int): Int {
        var answer: Double = price.toDouble()
        if(answer>=100000 && answer<300000){
            answer = answer * 0.95
        } else if (answer>=300000 && answer<500000) {
            answer = answer * 0.9
        } else if (answer>=500000) {
            answer = answer * 0.8
        }
        return answer.toInt()
    }
}