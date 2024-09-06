import java.util.LinkedList
import kotlin.math.max

val br = System.`in`.bufferedReader()

var answer = 0
var count = 0

fun main() = with(System.out.bufferedWriter()) {
    val n = br.readLine().toInt()
    val graph = Array(n) { IntArray(n) {0} }

    for(i in 0 until n) {
        graph[i] = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    for(h in 0 until 100) {
        count = 0
        val visited = Array(n) { IntArray(n) {0} }
        for(i in 0 until n) {
            for(j in 0 until n) {
                if(graph[i][j] > h  && visited[i][j] == 0) {
                    bfs(i, j, graph, visited, h)
                    answer = max(count, answer)
                }
            }
        }
    }


    write("$answer")

    close()
}

fun bfs(sX: Int, sY: Int, graph: Array<IntArray>, v: Array<IntArray>, h: Int) {
    val q = LinkedList<Pair<Int,Int>>()
    q.add(Pair(sX, sY))
    v[sX][sY] = 1
    

    while (q.isNotEmpty()) {
        val (cX, cY) = q.poll()

        if(cX - 1 >=0 && graph[cX - 1][cY] > h && v[cX - 1][cY] == 0) {
            q.add(Pair(cX - 1, cY))
            v[cX - 1][cY] = v[cX][cY] + 1
        }

        if(cX + 1 < graph.size && graph[cX + 1][cY] > h && v[cX + 1][cY] == 0) {
            q.add(Pair(cX + 1, cY))
            v[cX + 1][cY] = v[cX][cY] + 1
        }

        if(cY - 1 >=0 && graph[cX][cY - 1] > h && v[cX][cY - 1] == 0) {
            q.add(Pair(cX, cY - 1))
            v[cX][cY - 1] = v[cX][cY] + 1
        }

        if(cY + 1 < graph[0].size && graph[cX][cY + 1] > h && v[cX][cY + 1] == 0) {
            q.add(Pair(cX, cY + 1))
            v[cX][cY + 1] = v[cX][cY] + 1
        }
    }

    count++
}