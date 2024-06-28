val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {

    val n = br.readLine().toInt()

    val graph = Array(n + 1) { mutableListOf<Int>() }

    val visited = BooleanArray(n + 1)

    val parents = IntArray(n+1)

    for (i in 0 until n-1) {
        val (x, y) = br.readLine().split(" ").map { it.toInt() }

        graph[x].add(y)
        graph[y].add(x)
    }

    for (i in 1..n) {
        graph[i].sort()
    }

    dfs(1, graph, visited, parents)


    for(i in 2..n) {
        write("${parents[i]}\n")
    }
    close()
}
fun dfs(c: Int, graph: Array<MutableList<Int>>, v: BooleanArray, p:IntArray) {
    v[c] = true
    

    for (i in graph[c]) {
        if (!v[i]) {
            p[i]= c
            dfs(i, graph, v, p)
        }
    }
}