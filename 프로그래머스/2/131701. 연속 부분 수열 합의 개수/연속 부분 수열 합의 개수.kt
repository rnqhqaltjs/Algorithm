class Solution {
    fun solution(elements: IntArray): Int {
        var list = hashSetOf<Int>()
        var element = elements + elements
        
        for(i in 0 until elements.size) {
            var num = 0
            for(j in 0 until elements.size) {
                num += element[i+j]
                list.add(num)
            }
            num=0
        }
        return list.size
    }
}