class Solution {
    fun solution(n: Int): Int {
        var answer = n.toString()
        var sum = 0
        for (i in 0..answer.length-1) {
            sum+=answer[i].toString().toInt()
        }
        
        return sum
    }
}