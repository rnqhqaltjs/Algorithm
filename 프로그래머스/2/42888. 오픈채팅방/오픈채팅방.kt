class Solution {
    fun solution(record: Array<String>): Array<String> {
        var answer = mutableListOf<String>()
        val map = mutableMapOf<String, String>()
        val list = mutableListOf<Pair<String, Boolean>>()
        
        for(i in record) {
            val i = i.split(" ")
            val state = i[0]
            val uid = i[1]
            
            when(state) {
                "Enter" -> {
                    val name = i[2]
                    list.add(uid to true)
                    map[uid] = name
                }
                
                "Leave" -> {
                    list.add(uid to false)
                }
                
                "Change" -> {
                    val name = i[2]
                    map[uid] = name
                }
            }
            
        }
        
        for(i in list) {
            if(i.second) {
                answer.add("${map[i.first]!!}님이 들어왔습니다.")
            } else {
                answer.add("${map[i.first]!!}님이 나갔습니다.")
            }
        }
        return answer.toTypedArray()
    }
}