class Solution {
    fun solution(s: String): IntArray {
        var str = s.replace("{","").replace("}","").split(",")
        var hashMap: Map<String, Int> = str.groupingBy { it }.eachCount()
        println(hashMap)
//         for(i in str.indices) {
//             hashMap.put(str[i],str.count { it == str[i] })
//         }

        hashMap = hashMap.toList().sortedByDescending { it.second }.toMap()
        
        return hashMap.keys.map{it.toInt()}.toIntArray()
    }
}