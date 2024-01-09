class Solution {
    fun solution(brown: Int, yellow: Int): IntArray {
        var number = brown+yellow
        var list = IntArray(2)
        
        for (i in 2..number) {
            if(number % i == 0) {
                var height = number/i
                var width = i
                
                if((height-2)*(width-2)==yellow) {
                    list[0] = height
                    list[1] = width
                    break
                }
            }
        }    
        return list
    }
}