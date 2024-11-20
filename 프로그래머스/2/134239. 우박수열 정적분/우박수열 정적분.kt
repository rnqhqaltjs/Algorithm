class Solution {
    fun solution(k: Int, ranges: Array<IntArray>): DoubleArray {
        var answer = mutableListOf<Double>()
        var k = k
        val list = mutableListOf<Pair<Int,Int>>()
        var idx = 0
        var area = mutableListOf<Double>()
        
        list.add(idx to k)        
        while(k!=1) {
            idx++
            if(k%2==0) {
                k = k/2
                list.add(idx to k)
            } else {
                k = k*3 +1
                list.add(idx to k)
            }
        }
        
        for(i in 0 until list.size-1) {
            val (x1, y1) = list[i]
            val (x2, y2) = list[i+1]
            
            if(y1<y2) {
                area.add(((x2-x1) * y1) + ((y2-y1) * (x2-x1) /2.0))
            } else {
                area.add(((x2-x1) * y2) + ((y1-y2) * (x2-x1) /2.0))
            }
        }
        
        println(area)

        for(i in ranges.indices) {
            var start = ranges[i][0]
            var end = area.size + ranges[i][1]
            var sum = 0.0
            
            if(start>end) {
                answer.add(-1.0)
            } else if (start < end) {
                for(j in start until end) {
                    sum+=area[j]
                }
                answer.add(sum)
            } else {
                answer.add(0.0)
            }
        }
        return answer.toDoubleArray()
    }
}