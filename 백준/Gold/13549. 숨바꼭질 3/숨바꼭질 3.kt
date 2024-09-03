import java.util.LinkedList

val br = System.`in`.bufferedReader()
var k = 0

fun main() =with(System.out.bufferedWriter()){
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    val visited= Array(200001) { 0 }

    bfs(n, visited, k)

    close()
}

fun bfs(s: Int, v: Array<Int>, k: Int) {
    val q = LinkedList<Int>()
    q.add(s)
    v[s] = 1

    while (q.isNotEmpty()) {
        val c = q.poll()

        if(c==k) {
            print("${v[k] - 1}")
            return
        }

        if (c*2 in 0 until 200001 && v[c*2] == 0) {
            q.addFirst(c*2)
            v[c*2] = v[c]
        }
        
        if (c-1 in 0 until 200001 && v[c-1] == 0) {
            q.addLast(c-1)
            v[c-1] = v[c] + 1
        }

        if (c+1 in 0 until 200001 && v[c+1] == 0) {
            q.addLast(c+1)
            v[c+1] = v[c] + 1
        }

    }
}