class Solution {
    fun solution(numbers: IntArray): String {
        val result = numbers.map { it.toString() }
            .sortedWith(Comparator { a, b -> (b + a).compareTo(a + b) })
            .joinToString("")

        return if (result.startsWith("0")) "0" else result
    }
}