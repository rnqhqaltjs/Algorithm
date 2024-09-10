import java.util.LinkedList

val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val n = br.readLine().toInt()
    val (start, end) = br.readLine().split(" ").map { it.toInt() }
    val m = br.readLine().toInt()

    val graph = Array(n+1) { mutableListOf<Int>() }
    val visited = Array(n + 1) { 0 }

    repeat(m) {
        val (x, y) = br.readLine().split(" ").map { it.toInt() }

        graph[x].add(y)
        graph[y].add(x)
    }

   val answer =  bfs(start, end, graph, visited)

    write("$answer")
    close()
}

fun bfs(s:Int, e: Int, graph: Array<MutableList<Int>>, v: Array<Int>): Int {
    val q = LinkedList<Int>()
    q.add(s)
    v[s] = 1

    while (q.isNotEmpty()) {
        val c = q.poll()

        if(c == e) {
            return v[c] - 1
        }

        for(i in graph[c]) {
            if(v[i] == 0) {
                q.add(i)
                v[i] = v[c] + 1
            }
        }
    }

    return -1
}