import java.time.*

class Solution {
    fun solution(today: String, terms: Array<String>, privacies: Array<String>): IntArray {
        var answer = mutableListOf<Int>()
        val map = mutableMapOf<String, Int>()
        
        val today = today.split('.').map { it.toInt() }
        
        for(i in terms) {
            val (a,b) = i.split(' ')
            map[a] = b.toInt()
        }
        
        for(i in privacies.indices) {
            val (date, type) = privacies[i].split(' ')
            var (year, month, day) = date.split('.').map { it.toInt() }
            
            month += map.getOrDefault(type, 0)
            while(month>12) {
                year++
                month -= 12
            }
            val date1 = LocalDate.of(today[0], today[1], today[2])
            val date2 = LocalDate.of(year, month, day)
            
            if(date1 >= date2) {
                answer.add(i+1)
            }
            
        }
        return answer.toIntArray()
    }
}