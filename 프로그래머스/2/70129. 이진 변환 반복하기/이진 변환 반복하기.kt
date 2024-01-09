class Solution {
    fun solution(s: String): IntArray {   
        var digit = s.replace("0", "").length.toString(2)
        var repeat = 1
        var count = s.length - s.replace("0", "").length
        while(digit.length >1) {
            repeat++
            count += digit.length- digit.replace("0", "").length
            digit = digit.replace("0", "").length.toString(2)    
        }
        
        return intArrayOf(repeat, count)
    }
}