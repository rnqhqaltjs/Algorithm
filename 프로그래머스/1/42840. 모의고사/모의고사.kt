class Solution {
    fun solution(answers: IntArray): IntArray {
        var num1 = intArrayOf(1,2,3,4,5)
        var num2 = intArrayOf(2,1,2,3,2,4,2,5)
        var num3 = intArrayOf(3,3,1,1,2,2,4,4,5,5)
        var score = IntArray(3)
        var answer = intArrayOf()
        
        for(i in answers.indices) {
            if(answers[i] == num1[i%num1.size]) score[0]++
            if(answers[i] == num2[i%num2.size]) score[1]++
            if(answers[i] == num3[i%num3.size]) score[2]++       
        }
        
        if(score.maxOrNull() == score[0]) {
            answer+=1
        }
        if(score.maxOrNull() == score[1]) {
            answer+=2
        }
        if(score.maxOrNull() == score[2]) {
            answer+=3
        }
        
        return answer
    }
}