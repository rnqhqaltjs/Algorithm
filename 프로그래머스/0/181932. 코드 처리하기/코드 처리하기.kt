class Solution {
    fun solution(code: String): String {
        var answer: String = ""
        var mode = 0
        for(i in code.indices) {
            if(code[i]!='1' && i%2==0 && mode==0) {
                answer+=code[i]
            } else if(code[i]!='1' && i%2==1 && mode==1) {
                answer+=code[i]
            } else if (code[i]=='1') {
                if(mode==1) {
                    mode=0
                } else {
                    mode=1
                }
            }
        }
        return if(answer.length!=0) answer else "EMPTY" 
    }
}