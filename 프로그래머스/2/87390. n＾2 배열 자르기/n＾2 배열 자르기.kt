import kotlin.math.*

class Solution {
    fun solution(n: Int, left: Long, right: Long): IntArray {
        var list = ArrayList<Int>()
        for(i in left..right) {
            val x = (i / n.toLong()).toInt()
            val y = (i % n.toLong()).toInt()
            list.add(max(x,y)+1)
        }
        
        return list.toIntArray()
    }
}