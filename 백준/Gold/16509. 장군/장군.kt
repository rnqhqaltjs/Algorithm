import java.util.LinkedList

val br = System.`in`.bufferedReader()

val dX = arrayOf(0, 1, 0, -1)
val dY = arrayOf(1, 0, -1, 0)

val ddX = arrayOf(-1, 1, 1, -1)
val ddY = arrayOf(1, 1, -1, -1)

var resultX = 0
var resultY = 0

fun main() = with(System.out.bufferedWriter()) {
    val graph = Array(10) { IntArray(9) { 0 } }
    val visited = Array(10) { BooleanArray(9) }

    val (x, y) = br.readLine().split(" ").map { it.toInt() }
    val (kingX, kingY) = br.readLine().split(" ").map { it.toInt() }

    resultX = kingX
    resultY = kingY

    graph[kingX][kingY] = 1

    write("${bfs(x, y, graph, visited)}")

    close()
}

fun bfs(sX: Int, sY: Int, graph: Array<IntArray>, v: Array<BooleanArray>): Int {
    val q = LinkedList<Triple<Int, Int, Int>>()
    v[sX][sY] = true
    q.offer(Triple(sX, sY, 0))

    while (q.isNotEmpty()) {
        val (cX, cY, count) = q.poll()

        if (cX == resultX && cY == resultY) {
            return count
        }

        for (i in 0 until 4) {
            val nX = cX + dX[i]
            val nY = cY + dY[i]

            if (nX == resultX && nY == resultY) continue

            for (j in 0 until 2) {
                val s = (i + j) % 4
                var nnX = nX + ddX[s]
                var nnY = nY + ddY[s]

                if (nnX == resultX && nnY == resultY) continue

                nnX += ddX[s]
                nnY += ddY[s]

                if (nnX in graph.indices && nnY in graph[0].indices && !v[nnX][nnY]) {
                    v[nnX][nnY] = true
                    q.offer(Triple(nnX, nnY, count + 1))
                }
            }
        }
    }

    return -1
}