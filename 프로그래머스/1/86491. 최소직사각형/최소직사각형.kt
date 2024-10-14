class Solution {
    fun solution(sizes: Array<IntArray>): Int {
        var big = 0
        var small = 0
        
        for(i in sizes.indices) {
            if(sizes[i][0]>sizes[i][1]) {
                big = maxOf(big, sizes[i][0])
                small = maxOf(small, sizes[i][1])
            } else {
                big = maxOf(big, sizes[i][1])
                small = maxOf(small, sizes[i][0])
            }
        }
        return big * small
    }
}