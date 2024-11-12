class Solution {
    fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
        val answer = IntArray(id_list.size)
        val report = report.toSet()
        
        val map1 = mutableMapOf<String, MutableList<String>>()
        val map2 = mutableMapOf<String, Int>()
        
        for(i in report) {
            val (user, report) = i.split(' ')
            
            map1.getOrPut(report) { mutableListOf() }.add(user)
            map2[report] = map2.getOrDefault(report, 0) + 1
        }
        
        for((key, value) in map2) {
            if(value>=k) {
                for(i in map1.getOrDefault(key, mutableListOf())) {
                    answer[id_list.indexOf(i)]++
                }
            }
        }
        return answer
    }
}