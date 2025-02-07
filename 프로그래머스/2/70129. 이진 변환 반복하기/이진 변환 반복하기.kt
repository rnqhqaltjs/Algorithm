class Solution {
    fun solution(s: String): IntArray {
        var answer: IntArray = intArrayOf()
        
        var s = s
        var count = 0
        var repeat = 0
        
        while(s != "1") {
            repeat++
            var newStr = ""
            
            for(i in s) {
                if(i == '0') {
                    count++
                } else {
                    newStr+=i
                }
            }
            
            s = newStr.length.toString(2)
        }

        return intArrayOf(repeat, count)
    }
}