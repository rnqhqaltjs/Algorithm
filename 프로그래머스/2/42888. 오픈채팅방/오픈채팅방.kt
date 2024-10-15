class Solution {
    fun solution(record: Array<String>): Array<String> {
        var answer = mutableListOf<String>()
        val map = mutableMapOf<String, String>()
        val nickname = mutableListOf<Pair<String,Boolean>>()
        
        for(i in record) {
            val list = i.split(" ")
            
            when(list[0]) {
                "Enter" -> {
                    nickname.add(list[1] to true)
                    map[list[1]] = list[2]
                }
                "Leave" -> {
                    nickname.add(list[1] to false)
                }
                "Change" -> {
                    map[list[1]] = list[2]
                }
            }
        }
        
        for(i in nickname) {
            val (a,b) = i
            if(b == true) {
                answer.add("${map[a]}님이 들어왔습니다.")
            } else {
                answer.add("${map[a]}님이 나갔습니다.")
            }
        }
        return answer.toTypedArray()
    }
}