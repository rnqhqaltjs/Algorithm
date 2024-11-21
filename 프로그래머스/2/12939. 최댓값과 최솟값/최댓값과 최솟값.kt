class Solution {
    fun solution(s: String): String {
        var max = Int.MIN_VALUE
        var min = Int.MAX_VALUE
        var array = s.split(" ").map{ it.toInt() }
        
        for(i in array) {
            min = minOf(min, i)
            max = maxOf(max, i)
        }
        return "$min $max"
    }
}