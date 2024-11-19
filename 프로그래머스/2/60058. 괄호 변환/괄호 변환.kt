import java.util.*

class Solution {
    fun solution(p: String): String {
        return recursion(p)
    }
    
    fun recursion(p: String): String {
        var answer = ""
        if(p.length==0) return answer
        var u =""
        var v =""
        var op=0
        var cl=0
        
        for(i in p.indices) {
            u+=p[i]
            if(p[i] == '(') {
                op++
            } else {
                cl++
            }
            if(op==cl){
                v = p.substring(i+1,p.length)
                break
            }
        }
        
        if(isRight(u)) {
            answer+=u
            answer+=recursion(v)
        } else {
            var temp = '(' + recursion(v) + ')'
            val remove = u.substring(1, u.length-1)
            
            for(i in remove) {
                if(i == '(') {
                    temp+=')'
                } else {
                    temp+='('
                }
            }
            
            answer+=temp
        }
        
        return answer
    }
    
    fun isRight(p: String): Boolean {
        val stack = Stack<Char>()
        for(i in p.indices) {
            if(p[i] == '(') {
                stack.add('(')
            } else {
                if(stack.isEmpty()) {
                    return false
                } else {
                    stack.pop()
                }
            }
        }
        
        return true
    }
}