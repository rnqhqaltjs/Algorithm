class Solution {
    fun solution(array: IntArray): Int {
        var answer: Int = 0
        var map = array.toList().groupingBy { it }.eachCount().toList().sortedByDescending { it.second }.toMap() as MutableMap
        if(map.size>=2) {
            if(map.values.elementAt(0) == map.values.elementAt(1)) {
            return -1
        } else {
            return map.keys.elementAt(0)
            }
        } else {
            return map.keys.elementAt(0)
        }
        
    }
}