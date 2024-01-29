import kotlin.math.abs

class Solution {
    fun solution(a: Int, b: Int, c: Int, d: Int): Int {
        var answer: Int = 0
        var list: IntArray = intArrayOf()
        list = list + a + b + c + d
        list.sort()
        
        if(list[0] == list[3]) {
            answer = 1111 * list[0]
        } else if (list[3] == list[1]) {
            answer = (10 * list[3] + list[0]) * (10 * list[3] + list[0])
        } else if (list[0] == list[2]) {
            answer = (10 * list[0] + list[3]) * (10 * list[0] + list[3])
        } else if (list [0] == list[1] && list [2] == list[3]) {
            answer = (list[3] + list[0]) * (list[3] - list[0])
        } else if (list[0] == list[1]) {
            answer = list[2] * list[3]
        } else if (list[1] == list[2]) {
            answer = list[0] * list[3]
        } else if (list[2] == list[3]) {
            answer = list[0] * list[1]
        } else {
            answer = list[0]
        }
        return answer
    }
}