val br = System.`in`.bufferedReader()

var count = 1
val dx = arrayOf(-1, 0, 1, 0)
val dy = arrayOf(0, 1, 0, -1)
lateinit var graph: Array<IntArray>

fun main() = with(System.out.bufferedWriter()) {
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val (r, c, d) = br.readLine().split(" ").map { it.toInt() }
    graph = Array(n) { IntArray(m) }

    for(i in 0 until n) {
        val line = br.readLine().split(" ").map { it.toInt() }
        for(j in 0 until m) {
            graph[i][j] = line[j]
        }
    }

    clean(r,c, d)
    write("$count")
    close()
}

fun clean(ci: Int, cj: Int, d:Int) {
    graph[ci][cj] = -1

    var direction = d
    for(i in 0 until 4) {
        direction = (direction+3) % 4

        val nx = ci + dx[direction]
        val ny = cj + dy[direction]

        if(nx in graph.indices && ny in graph[0].indices && graph[nx][ny] == 0) {
            count++
            clean(nx, ny, direction)
            return
        }
    }

    val backDirection = (d+2) % 4
    val bx = ci + dx[backDirection]
    val by = cj + dy[backDirection]

    if(bx in graph.indices && by in graph[0].indices && graph[bx][by] != 1) {
        clean(bx, by, d)
    }
}