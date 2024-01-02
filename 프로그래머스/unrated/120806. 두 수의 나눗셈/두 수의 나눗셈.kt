class Solution {
    fun solution(num1: Int, num2: Int): Int {
        var answer: Int = 0
        var tmp = num1.toDouble() / num2.toDouble()
        return (tmp*1000).toInt()
    }
}