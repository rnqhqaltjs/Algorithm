class Solution {
    fun solution(book_time: Array<Array<String>>): Int {
        val rooms = mutableListOf<Int>()
        val book_time = book_time.sortedWith(compareBy{it[0]})
        val temp = mutableListOf<Int>()

        for(i in book_time) {
            val (start, end) = i
            var startTime = start.split(":") .map { it.toInt() }.let { it[0] * 60 + it[1] }
            var endTime = end.split(":") .map { it.toInt() }.let { it[0] * 60 + it[1] }
            var flag = 0
            
            for(i in rooms.indices) {
                if(rooms[i] + 10 <= startTime) {
                    rooms[i] = endTime
                    flag = 1
                    break
                }
            }
            
            if(flag == 0) {
                rooms.add(endTime)
            }
            
            rooms.sort()
        }
        return rooms.size
    }
}