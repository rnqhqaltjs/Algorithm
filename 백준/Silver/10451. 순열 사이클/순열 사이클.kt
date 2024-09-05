val br = System.`in`.bufferedReader()
var count = 0

fun main() = with(System.out.bufferedWriter()) {
    val t = br.readLine().toInt()

    repeat(t) {
        count = 0

        val n = br.readLine().toInt()
        val graph = Array(n + 1) { mutableListOf<Int>() }
        val visited = BooleanArray(n + 1)
        val x = br.readLine().split(" ").map { it.toInt() }

        for (i in 1 .. n) {
            graph[i].add(x[i-1])
        }
        for (j in 1..n) {
        if (!visited[j]) {
            count+= dfs(j, graph, visited)
        }
    }

        dfs(1, graph, visited)

        write("$count\n")
    }


    close()
}

fun dfs(c: Int, graph: Array<MutableList<Int>>, v: BooleanArray) : Int{
    v[c] = true

    for (i in graph[c]) {
        if (!v[i]) {
            count++
            dfs(i, graph, v)
        }
    }
    
    return 1
}