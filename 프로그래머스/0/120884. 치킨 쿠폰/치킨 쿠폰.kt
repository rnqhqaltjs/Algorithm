class Solution {
    fun solution(chicken: Int): Int {
        var coupon = chicken
        var answer = 0
        
        while(coupon>9) {
            answer+= (coupon/10)
            coupon = (coupon%10)+(coupon/10)
        }
        return answer
    }
}