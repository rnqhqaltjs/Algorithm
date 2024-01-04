class Solution {
    fun solution(money: Int): IntArray {
        var answer: IntArray = intArrayOf(0,0)
        var a = money
        var b = 0
        
        if(a<5500) {
            answer[1] = a
        } else {
            while(a>=5500) {
            a -= 5500
            b++
            answer[0] = b
            answer[1] = a
        }
        }
        
        
        
        return answer
    }
}