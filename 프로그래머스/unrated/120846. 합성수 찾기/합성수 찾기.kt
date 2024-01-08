class Solution { 
    fun solution(n: Int): Int {
        var answer: Int = 0
        for (i in 1..n) {
            var isPrime = true
            for (j in 2 until i) {
                if (i % j == 0) {
                    isPrime = false
                    break
                }
            }
            if (!isPrime) {
                answer++
            }
        }
        return answer
    }
}