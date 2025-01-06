import java.util.*

class Solution {
    val dX = intArrayOf(1, 0, 0, -1)
    val dY = intArrayOf(0, -1, 1, 0)
    val direction = arrayOf('d', 'l', 'r', 'u')
    var answer = mutableSetOf<String>()

    fun solution(n: Int, m: Int, x: Int, y: Int, r: Int, c: Int, k: Int): String {
        val graph = Array(n) { CharArray(m) { '.' } }
        graph[x - 1][y - 1] = 'S'
        graph[r - 1][c - 1] = 'E'

        return bfs(x - 1, y - 1, r - 1, c - 1, n, m, k)
    }

    data class Cmd(
        val x: Int,
        val y: Int,
        val count: Int,
        val word: String
    )

    fun bfs(sX: Int, sY: Int, eX: Int, eY: Int, n: Int, m: Int, k: Int): String {
        val q = LinkedList<Cmd>()
        val visited = Array(n) { Array(m) { BooleanArray(k + 1) { false } } }
        q.offer(Cmd(sX, sY, 0, ""))
        visited[sX][sY][0] = true

        while (q.isNotEmpty()) {
            val (cX, cY, count, word) = q.poll()

            if (count == k) {
                if (cX == eX && cY == eY) {
                    return word
                }
                continue
            }

            for (i in 0 until 4) {
                val nX = cX + dX[i]
                val nY = cY + dY[i]
                val nextCount = word.length + 1

                if (nX in 0 until n && nY in 0 until m) {
                    if (!visited[nX][nY][nextCount]) {
                        visited[nX][nY][nextCount] = true
                        q.offer(Cmd(nX, nY, nextCount, word + direction[i]))
                    }
                }
            }
        }
        
        return "impossible"
    }
}
