import java.util.*

class Solution {
    fun solution(board: Array<IntArray>, moves: IntArray): Int {
        var answer = 0
        val stack = Stack<Int>()
        
        for(i in moves) {
            for(j in board.indices) {
                if(board[j][i-1] !=0) {
                    stack.push(board[j][i-1])
                    board[j][i-1] = 0 
                    
                    if(stack.size>=2) {
                        if(stack[stack.size-1] == stack[stack.size-2]) {
                            stack.pop()
                            stack.pop()
                            answer+=2
                        }
                    }
                    
                    break
                }
                
                
            }
        }
        return answer
    }
}