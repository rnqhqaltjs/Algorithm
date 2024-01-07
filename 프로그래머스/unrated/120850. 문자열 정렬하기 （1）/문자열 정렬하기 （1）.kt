class Solution {
    fun solution(my_string: String): IntArray {
        var a = my_string.replace("[^0-9]".toRegex(), "")
        var answer: IntArray = intArrayOf()
        for(i in 0..a.length-1) {
            answer += a[i].toString().toInt()
        }
        answer.sort()
        return answer
    }
}