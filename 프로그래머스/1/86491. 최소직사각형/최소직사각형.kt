class Solution {
    fun solution(sizes: Array<IntArray>): Int {
        var answer: Int = 0
        var bigList = mutableListOf<Int>()
        var smallList = mutableListOf<Int>()
        
        for(i in sizes) {
            var (a, b) = i
            
            if(a>b) {
                bigList.add(a)
                smallList.add(b)
            } else {
                smallList.add(a)
                bigList.add(b)
            }
        }
        
        return bigList.maxOf{ it } * smallList.maxOf{ it }
    }
}