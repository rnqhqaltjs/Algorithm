val br = System.`in`.bufferedReader()

val dX = arrayOf(-1, 0, 1, 0)
val dY = arrayOf(0, 1, 0, -1)

var answer = "No"

var startX = 0
var startY = 0

fun main() = with(System.out.bufferedWriter()) {
    val (n, m) = br.readLine().split(" ").map { it.toInt() }

    val graph = Array(n) { br.readLine().toCharArray() }

    for (i in 0 until n) {
        for (j in 0 until m) {
            val visited = Array(n) { BooleanArray(m) }
            startX = i
            startY = j

            dfs(i, j, 1, graph, visited)
            if (answer == "Yes") {
                write(answer)
                close()
                return@with
            }
        }
    }

    write(answer)
    close()
}

fun dfs(sX: Int, sY: Int, count: Int, graph: Array<CharArray>, v: Array<BooleanArray>) {
    v[sX][sY] = true

    for (i in 0 until 4) {
        val nX = dX[i] + sX
        val nY = dY[i] + sY

        if (nX in graph.indices && nY in graph[0].indices && graph[nX][nY] == graph[sX][sY]) {
            if (!v[nX][nY]) {
                v[nX][nY] = true
                dfs(nX, nY, count + 1, graph, v)
            } else {
                if (count >= 4 && startX == nX && startY == nY) {
                    answer = "Yes"
                    return
                }
            }
        }
    }
}