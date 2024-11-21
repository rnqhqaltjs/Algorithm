class Solution {
    fun solution(s: String): IntArray {
        var str = s
        
        var repeat = 0
        var count = 0
        
        while(str!="1") {
            var temp = ""
            repeat++
            
            for(i in str) {
                if(i=='1') {
                    temp+=i
                } else {
                    count++
                }
            }
            
            str = temp.length.toString(2)
        }
        
        return intArrayOf(repeat, count)
    }
}