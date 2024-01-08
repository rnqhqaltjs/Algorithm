class Solution {
    fun solution(order: Int): Int {
        var answer = order.toString().toCharArray()
        var count = 0
        for(i in answer) {
            if (i == '3' || i == '6' || i == '9') {
                count++
            }
        }
        return count
    }
}