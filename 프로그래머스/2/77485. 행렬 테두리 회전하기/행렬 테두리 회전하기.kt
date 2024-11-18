class Solution {
    fun solution(rows: Int, columns: Int, queries: Array<IntArray>): IntArray {
        var answer = mutableListOf<Int>()
        val array = Array(rows) { IntArray(columns) }
        var count = 1
        
        for(i in 0 until rows) {
            for(j in 0 until columns) {
                array[i][j] = count
                count++
            }
        }
        
        for(i in queries) {
            val x1 = i[0] -1
            val y1 = i[1] -1
            val x2 = i[2] -1
            val y2 = i[3] -1
            val temp = array[x1][y2]
            var min = temp
            
            for(i in y2 - 1 downTo y1) {
                array[x1][i+1] = array[x1][i] 
                min = minOf(min, array[x1][i])
            }
            
            for(i in x1 + 1 .. x2) {
                array[i-1][y1] = array[i][y1]
                min = minOf(min, array[i][y1])
            }
            
            for(i in y1 + 1 .. y2) {
                array[x2][i-1] = array[x2][i]
                min = minOf(min, array[x2][i])
            }
            
            for(i in x2 - 1 downTo x1) {
                array[i+1][y2] = array[i][y2]
                min = minOf(min, array[i][y2])
            }
            
            array[x1+1][y2] = temp
            answer.add(min)
        }
        
        return answer.toIntArray()
    }
}