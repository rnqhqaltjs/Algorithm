class Solution {
    fun solution(s: String): String {
        var answer = ""
        
        var array = s.split(" ").map { it.toInt() }
        print(array)
        array = array.sorted()
        
        
        return "${array[0]} ${array[array.size - 1]}"
    }
}