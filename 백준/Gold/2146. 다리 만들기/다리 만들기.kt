import java.util.LinkedList
import java.util.Queue
import kotlin.math.min

val dx = arrayOf(1, 0, 0, -1)
val dy = arrayOf(0, 1, -1, 0)

var n = 0
lateinit var map : Array<IntArray>
lateinit var visited : Array<BooleanArray>

var ans = Int.MAX_VALUE

fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()

    map = Array(n) { readLine().split(" ").map { it.toInt() }.toIntArray() }
    visited = Array(n) { BooleanArray(n) }

    for (i in 0 until n) {
        for (j in 0 until n) {
            if (map[i][j] == 1 && !visited[i][j]) {
                findLand(i, j)
            }
        }
    }

    for (i in 0 until n) {
        for (j in 0 until n) {
            if (map[i][j] != 0) {
                findBridge(i, j, map[i][j])
            }
        }
    }

    println(ans)
}

var landNum = 1
fun findLand(nowX: Int, nowY: Int) {
    val queue : Queue<Pair<Int, Int>> = LinkedList()
    queue.add(nowX to nowY)
    visited[nowX][nowY] = true
    map[nowX][nowY] = landNum

    while (queue.isNotEmpty()) {
        val (x, y) = queue.poll()

        for (i in 0 until 4) {
            val tempX = x + dx[i]
            val tempY = y + dy[i]

            if (tempX in 0 until n &&
                tempY in 0 until n &&
                !visited[tempX][tempY] &&
                map[tempX][tempY] == 1) {
                visited[tempX][tempY] = true
                queue.add(tempX to tempY)
                map[tempX][tempY] = landNum
            }
        }
    }

    landNum++
}

data class Bridge(val x: Int, val y: Int, val cnt: Int)
fun findBridge(nowX: Int, nowY: Int, land: Int) {
    val queue : Queue<Bridge> = LinkedList()
    val visitedSea = Array(n) { BooleanArray(n) }
    queue.add(Bridge(nowX, nowY, 0))
    visitedSea[nowX][nowY] = true

    while (queue.isNotEmpty()) {
        val (x, y, cnt) = queue.poll()

        if (cnt - 1 >= ans) {
            return
        }

        if (map[x][y] != 0 && map[x][y] != land) {
            ans = min(ans, cnt - 1)
            return
        }

        for (i in 0 until 4) {
            val tempX = x + dx[i]
            val tempY = y + dy[i]

            if (tempX in 0 until n &&
                tempY in 0 until n &&
                !visitedSea[tempX][tempY] &&
                map[tempX][tempY] != land) {
                visitedSea[tempX][tempY] = true
                queue.add(Bridge(tempX, tempY, cnt + 1))
            }
        }
    }
}