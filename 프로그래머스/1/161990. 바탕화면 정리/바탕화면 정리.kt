class Solution {
    fun solution(wallpaper: Array<String>): IntArray {
        var answer: IntArray = intArrayOf()
        
        var top = Int.MAX_VALUE
        var bottom = Int.MIN_VALUE
        var left = Int.MAX_VALUE
        var right = Int.MIN_VALUE
        
        for(i in wallpaper.indices) {
            for(j in wallpaper[i].indices) {
                if(wallpaper[i][j] == '#') {
                    top = minOf(i, top)
                    bottom = maxOf(i + 1, bottom)
                    left = minOf(j, left)
                    right = maxOf(j + 1, right)
                }
            }
        }
        
        
        return intArrayOf(top, left, bottom, right)
    }
}