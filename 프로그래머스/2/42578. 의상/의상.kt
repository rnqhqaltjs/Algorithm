class Solution {
    fun solution(clothes: Array<Array<String>>): Int {
        var list = emptyArray<String>()
        var map : Map<String,Int> = hashMapOf()
        var answer = 1
        
        for(i in clothes) {
            list+=i[1]
        }
        map = list.groupingBy { it }.eachCount()
        map.forEach{ answer*=it.value+1 }

        return answer-1
    }
}