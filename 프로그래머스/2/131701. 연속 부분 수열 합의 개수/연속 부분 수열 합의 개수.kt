class Solution {
    fun solution(elements: IntArray): Int {
        var answer = mutableSetOf<Int>()
        var element = elements + elements
        
        for(i in elements.indices) {
            var num = 0
            for(j in elements.indices) {
                num+= element[i+j]
                answer.add(num)
            }
        }
        return answer.size
    }
}