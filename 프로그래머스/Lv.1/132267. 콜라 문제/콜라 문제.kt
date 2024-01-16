class Solution {
    fun solution(a: Int, b: Int, n: Int): Int {
        var answer: Int = 0
        var count = n
        while(count>=a) {
            val quotient = count/a
            val bottle = quotient * b
            count = count - a*quotient + bottle
            answer+= bottle
        }
        return answer
    }
}