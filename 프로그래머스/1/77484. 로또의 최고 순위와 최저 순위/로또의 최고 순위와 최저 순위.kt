class Solution {
    fun solution(lottos: IntArray, win_nums: IntArray): IntArray {
        var answer: IntArray = intArrayOf()
        var zero_count = 0
        var count = 0
        
        for(i in lottos.indices) {
            if(lottos[i] == 0) {
                zero_count++
            }    
            for(j in win_nums.indices) {
                if(lottos[i] == win_nums[j]) {
                    count++
                }
            }
        }
        
        var max_rank = 7 - (count + zero_count)
        var min_rank = 7 - count
        
        if(max_rank == 7) {
            max_rank = 6
        } 
        
        if(min_rank == 7) {
            min_rank = 6
        }
        
        return intArrayOf(max_rank, min_rank)
    }
}