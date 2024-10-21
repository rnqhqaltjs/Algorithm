var answer: IntArray = intArrayOf(0, 0)

class Solution {
    fun solution(arr: Array<IntArray>): IntArray {
        quad(0, 0, arr.size, arr)
        return answer
    }

    fun quad(x: Int, y: Int, size: Int, arr: Array<IntArray>) {
        if (zip(x, y, size, arr)) {
            if (arr[x][y] == 1) {
                answer[1] += 1
            } else {
                answer[0] += 1
            }
            return
        }
        val half = size / 2
        quad(x, y, half, arr)
        quad(x, y + half, half, arr)
        quad(x + half, y, half, arr)
        quad(x + half, y + half, half, arr)
    }

    fun zip(x: Int, y: Int, size: Int, arr: Array<IntArray>): Boolean {
        val value = arr[x][y]
        for (i in x until x + size) {
            for (j in y until y + size) {
                if (arr[i][j] != value) {
                    return false
                }
            }
        }
        return true
    }
}