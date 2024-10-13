class Solution {
    fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
        var answer = 0
        var mutableLost = (lost.toSet() - reserve.toSet()).sorted().toMutableSet()
        var mutableReserve = (reserve.toSet() - lost.toSet()).sorted().toMutableSet()

        for(i in mutableReserve) {
            if(i-1 in mutableLost) {
                mutableLost.remove(i-1)
            } else if (i+1 in mutableLost) {
                mutableLost.remove(i+1)
            }
        }
        
        return  n - mutableLost.size
    }
}