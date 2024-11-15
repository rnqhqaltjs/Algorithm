class Solution {
    fun solution(n: Int): IntArray {
        val triangle = Array(n) { IntArray(it + 1) }
        var value = 1
        var row = 0
        var col = 0
        var dir = arrayOf(arrayOf(1,0), arrayOf(0,1), arrayOf(-1,-1))
        var idx = 0
        var max = n
        var count = 0
        
        while (max!=0){
            triangle[row][col]= value++

            count++
            if(count==max){
                idx++
                count=0
                max--
            }
            row += dir[idx%3][0]
            col += dir[idx%3][1]
        }

        return triangle.flatMap { it.toList() }.toIntArray()
    }
}