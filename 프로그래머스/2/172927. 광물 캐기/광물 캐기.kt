class Solution {
    fun solution(picks: IntArray, minerals: Array<String>): Int {
        var answer = 0
        val groupCount = (minerals.size + 4) / 5
        val totalPicks = picks.sum() * 5
        val actualMinerals = minerals.take(totalPicks)
        val arr = Array(groupCount) { IntArray(3) }

        for (i in actualMinerals.indices) {
            val groupIndex = i / 5
            when (actualMinerals[i]) {
                "diamond" -> arr[groupIndex][0]++
                "iron" -> arr[groupIndex][1]++
                else -> arr[groupIndex][2]++
            }
        }
        
        arr.sortWith(compareBy({ -it[0] }, { -it[1] }, { -it[2] }))
        
        for(i in arr) {
            if(picks[0]>0) {
                answer+= i[0] + i[1] + i[2]
                picks[0]--
            } else if (picks[1]>0) {
                answer+= i[0] * 5 + i[1] + i[2]
                picks[1]--
            } else if (picks[2]>0) {
                answer+= i[0] * 25 + i[1] * 5 + i[2]
                picks[2]--
            }
        }
        return answer
    }
}