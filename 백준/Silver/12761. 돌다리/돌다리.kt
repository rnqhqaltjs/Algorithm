import java.util.LinkedList

val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (a, b, n, m) = br.readLine().split(" ").map { it.toInt() }
    val visited = IntArray(100001) { 0 }

    bfs(n, visited, a, b, m)

    close()
}

fun bfs(s: Int, v: IntArray, a: Int, b: Int, goal: Int) {
    val q = LinkedList<Int>()
    q.add(s)
    v[s] = 1

    while (q.isNotEmpty()) {
        val c = q.poll()

        if (c == goal) {
            print("${v[c] - 1}")
            return
        }

        if (c * b < v.size && v[c * b] == 0) {
            q.add(c * b)
            v[c * b] = v[c] + 1
        }

        if (c * a < v.size && v[c * a] == 0) {
            q.add(c * a)
            v[c * a] = v[c] + 1
        }

        if (c + b < v.size && v[c + b] == 0) {
            q.add(c + b)
            v[c + b] = v[c] + 1
        }

        if (c + a < v.size && v[c + a] == 0) {
            q.add(c + a)
            v[c + a] = v[c] + 1
        }

        if (c - a >= 0 && v[c - a] == 0) {
            q.add(c - a)
            v[c - a] = v[c] + 1
        }

        if (c - b >= 0 && v[c - b] == 0) {
            q.add(c - b)
            v[c - b] = v[c] + 1
        }

        if (c + 1 < v.size && v[c + 1] == 0) {
            q.add(c + 1)
            v[c + 1] = v[c] + 1
        }

        if (c - 1 >= 0 && v[c - 1] == 0) {
            q.add(c - 1)
            v[c - 1] = v[c] + 1
        }
    }
}