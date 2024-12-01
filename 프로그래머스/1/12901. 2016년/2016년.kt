class Solution {
    val month = arrayOf(0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
    val week = arrayOf("SUN","MON","TUE","WED","THU","FRI","SAT")
    
    fun solution(a: Int, b: Int): String {
        var answer = ""
        var count = 0
        for(i in 0 until a) {
            count+= month[i]
        }
        
        count+=b
        
        
        return week[(count+4) % 7]
    }
}