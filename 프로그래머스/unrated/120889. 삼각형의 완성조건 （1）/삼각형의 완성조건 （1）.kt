class Solution {
    fun solution(sides: IntArray): Int {
        var answer = sides.sorted()
        if(answer[2]<answer[0] + answer[1]) {
            return 1
        } else {
            return 2
        }
    }
}