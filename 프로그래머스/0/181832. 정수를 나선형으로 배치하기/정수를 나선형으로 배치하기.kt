class Solution {
    fun solution(n: Int): Array<IntArray> {
        val answer = Array(n) { IntArray(n) { -1 } }
        
        var x = 0
        var y = 0
        var direction = "right"
        
        for (i in 1..n*n) {
            answer[x][y] = i
            
            when (direction) {
                "right" -> {
                    if (y + 1 >= n || answer[x][y + 1] != -1) {
                        direction = "down"
                        x++
                    } else {
                        y++
                    }
                }
                "down" -> {
                    if (x + 1 >= n || answer[x + 1][y] != -1) {
                        direction = "left"
                        y--
                    } else {
                        x++
                    }
                }
                "left" -> {
                    if (y - 1 < 0 || answer[x][y - 1] != -1) {
                        direction = "up"
                        x--
                    } else {
                        y--
                    }
                }
                "up" -> {
                    if (x - 1 < 0 || answer[x - 1][y] != -1) {
                        direction = "right"
                        y++
                    } else {
                        x--
                    }
                }
            }
        }
        return answer
    }
}