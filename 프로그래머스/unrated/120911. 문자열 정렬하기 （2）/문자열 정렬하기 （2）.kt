class Solution {
    fun solution(my_string: String): String {
        return String(my_string.lowercase().toCharArray().apply { sort() })
    }
}