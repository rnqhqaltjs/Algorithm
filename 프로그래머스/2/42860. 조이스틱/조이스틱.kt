

class Solution {
    fun solution(name: String): Int {
        var answer = 0
        var min = name.length - 1
        
        for(i in name.indices) {
            answer+= minOf(name[i] - 'A', 'Z'- name[i] + 1)
            
            var index = i + 1
            
            while(index < name.length && name[index] == 'A') {
                index++
            }
            
            min = minOf(min, i * 2 + name.length - index, i + 2 * (name.length - index))
        }
        
        return answer + min
    }
}