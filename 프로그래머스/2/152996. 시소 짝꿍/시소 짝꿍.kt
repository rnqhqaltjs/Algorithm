class Solution {
    fun solution(weights: IntArray): Long {
        var answer: Long = 0
        val w = weights.sorted().toIntArray()
        
        for(i in w.indices) {
            for(j in i+1 until w.size) {
                if(w[i] == w[j]) {
                    answer++
                } else if (w[i] * 2 == w[j]) {
                    answer++
                } else if (w[i] * 3 == w[j] * 2) {
                    answer++
                } else if (w[i] * 4 == w[j] * 3) {
                    answer++
                }
            }
        }
        return answer
    }
}