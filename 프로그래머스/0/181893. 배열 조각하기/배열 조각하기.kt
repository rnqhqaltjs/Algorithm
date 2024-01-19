class Solution {
    fun solution(arr: IntArray, query: IntArray): IntArray {
        var answer: IntArray = arr.clone()
        for(i in query.indices) {
           if(i% 2 == 0) {
               answer = answer.sliceArray(0 .. query[i])
           } else {
               answer = answer.sliceArray(query[i] until answer.size)
            }
        }
        return answer
    }
}