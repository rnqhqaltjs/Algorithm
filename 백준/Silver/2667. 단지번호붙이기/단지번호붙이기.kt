import java.util.LinkedList

val br = System.`in`.bufferedReader()

val countList = mutableListOf<Int>()
var count = 0

fun main() = with(System.out.bufferedWriter()) {
    val n = br.readLine().toInt()
    val graph = Array(n) { IntArray(n) {0} }
    val visited = Array(n) { IntArray(n) {0} }

    for(i in 0 until n) {
        graph[i] = br.readLine().map { it.code - '0'.code }.toIntArray()
    }


    for(i in 0 until n) {
        for(j in 0 until n) {
            if(graph[i][j] == 1  && visited[i][j] == 0) {
                bfs(i, j, graph, visited)
            }
        }
    }

    countList.sort()

    write("${countList.size}\n")
    for(i in countList) {
        write("$i\n")
    }

    close()
}

fun bfs(sX: Int, sY: Int, graph: Array<IntArray>, v: Array<IntArray>) {
    count = 1
    val q = LinkedList<Pair<Int,Int>>()
    q.add(Pair(sX, sY))
    v[sX][sY] = 1

    while (q.isNotEmpty()) {
        val (cX, cY) = q.poll()

        if(cX - 1 >=0 && graph[cX - 1][cY] == 1 && v[cX - 1][cY] == 0) {
            q.add(Pair(cX - 1, cY))
            v[cX - 1][cY] = v[cX][cY] + 1
            count++
        }

        if(cX + 1 < graph.size && graph[cX + 1][cY] == 1 && v[cX + 1][cY] == 0) {
            q.add(Pair(cX + 1, cY))
            v[cX + 1][cY] = v[cX][cY] + 1
            count++
        }

        if(cY - 1 >=0 && graph[cX][cY - 1] == 1 && v[cX][cY - 1] == 0) {
            q.add(Pair(cX, cY - 1))
            v[cX][cY - 1] = v[cX][cY] + 1
            count++
        }

        if(cY + 1 < graph[0].size && graph[cX][cY + 1] == 1 && v[cX][cY + 1] == 0) {
            q.add(Pair(cX, cY + 1))
            v[cX][cY + 1] = v[cX][cY] + 1
            count++
        }
    }
    countList.add(count)
}