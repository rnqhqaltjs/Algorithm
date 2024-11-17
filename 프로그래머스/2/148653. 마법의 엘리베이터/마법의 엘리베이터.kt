class Solution {
    fun solution(storey: Int): Int {
        var temp = storey
        var count = 0
        
        while(temp>0) {
            val ext = temp%10
            temp/=10
            
            if(ext>5) {
                temp++
                count+=10-ext
            } else if (ext<5) {
                count+= ext
            } else {
                if(temp%10 >=5) {
                    temp++
                    count+=10-ext
                }
                else {
                    count+=ext
                }
            }
        }
        return count
    }
}