class Solution {
    fun solution(A: String, B: String): Int {
        var answer: Int = 0
        var a = A
        for(i in A.indices) {
            if(a==B) {
                break
            }
            a = a[a.length-1] + a.substring(0, a.length-1)
            answer++
        }
        return if(answer==A.length) -1 else answer
    }
}