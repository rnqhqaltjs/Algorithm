class Solution {
    fun solution(k: Int, tangerine: IntArray): Int {
        var list = IntArray(tangerine.maxOrNull()!! + 1)
        var k = k
        var count = 0

        for (i in tangerine) {
            list[i]++
        }
        
        list = list.sortedDescending().toIntArray()

        for (i in list) {
            count++
            k -= i
            if (k <= 0) {
                break
            }
        }
        return count
    }
}