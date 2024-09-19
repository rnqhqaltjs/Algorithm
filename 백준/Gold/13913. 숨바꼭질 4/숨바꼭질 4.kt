import java.util.LinkedList

val br = System.`in`.bufferedReader()

val node = mutableListOf<Int>()
fun main() = with(System.out.bufferedWriter()) {
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    val visited = IntArray(100001) { -1 }

    bfs(n, k, visited)
    close()
}

fun bfs(s: Int, e: Int, v: IntArray) {
    val q = LinkedList<Pair<Int, Int>>()
    q.offer(s to 0)
    v[s] = s

    while (q.isNotEmpty()) {
        val (c, count) = q.poll()

        if (c == e) {
            println(count)

            val path = mutableListOf<Int>()
            var idx = c

            while (idx != s) {
                path.add(idx)
                idx = v[idx]
            }
            path.add(s)
            path.reverse()
            println(path.joinToString(" "))
        }

        if (c - 1 in v.indices && v[c - 1] == -1) {
            q.offer(c - 1 to count + 1)
            node.add(c)
            v[c - 1] = c
        }

        if (c + 1 in v.indices && v[c + 1] == -1) {
            q.offer(c + 1 to count + 1)
            node.add(c + 2)
            v[c + 1] = c
        }

        if (c * 2 in v.indices && v[c * 2] == -1) {
            q.offer(c * 2 to count + 1)
            node.add(c * 2 + 1)
            v[c * 2] = c
        }
    }
}