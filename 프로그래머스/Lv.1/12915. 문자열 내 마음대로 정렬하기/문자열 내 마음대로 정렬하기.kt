class Solution {
    fun solution(strings: Array<String>, n: Int): Array<String> {
        var answer = strings.toList()
        answer = answer.sorted().sortedBy {
            it[n]
        }
        return answer.toTypedArray()
    }
}