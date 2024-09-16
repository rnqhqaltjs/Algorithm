import java.util.LinkedList

val br = System.`in`.bufferedReader()

var allCount = 0
var min = Int.MAX_VALUE
var answer = 0

fun main() = with(System.out.bufferedWriter()) {
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val graph = Array(n + 1) { mutableListOf<Int>() }

    repeat(m) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }

        graph[a].add(b)
        graph[b].add(a)
    }

    for (i in 1..n) {
        allCount = 0
        for (j in 1..n) {
            if (i == j) continue
            val visited = BooleanArray(n + 1)
            allCount += bfs(i, j, graph, visited)
        }

        if(allCount< min) {
            min = allCount
            answer = i
        }
    }

    write("$answer")
    close()
}

fun bfs(s: Int, e: Int, graph: Array<MutableList<Int>>, v: BooleanArray): Int {
    val q = LinkedList<Pair<Int, Int>>()
    q.add(s to 0)
    v[s] = true

    while (q.isNotEmpty()) {
        val (c, count) = q.poll()

        if (c == e) return count

        for (i in graph[c]) {
            if (!v[i]) {
                q.add(i to count + 1)
                v[i] = true
            }
        }
    }
    return 0
}