class Solution {
    fun solution(k: Int, m: Int, score: IntArray): Int {
        var list = score.sortedDescending()
        var answer: Int = 0
        
        for(i in 0 until list.size step(m)) {
            try {
                answer+=list.slice(i until i+m).last()*m
            } catch (e:IndexOutOfBoundsException) {
                break
            }
        }
        return answer
    }
}