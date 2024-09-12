import java.util.LinkedList

val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (f, s, g, u, d) = br.readLine().split(" ").map { it.toInt() }
    val visited = LongArray(f + 1) { 0 }

    bfs(s, visited, u, d, g)

    close()
}

fun bfs(s:Int, v: LongArray, up: Int, down: Int, goal: Int) {
    val q = LinkedList<Int>()
    q.add(s)
    v[s] = 1

    while (q.isNotEmpty()) {
        val c = q.poll()

        if(c == goal) {
            print("${v[c] - 1}")
            return
        }

        if(c + up < v.size && v[c + up] == 0L) {
            q.add(c+up)
            v[c + up] = v[c] + 1
        }

        if(c - down >= 1 && v[c - down] == 0L) {
            q.add(c - down)
            v[c - down] = v[c] + 1
        }



    }

    print("use the stairs")
    return
}