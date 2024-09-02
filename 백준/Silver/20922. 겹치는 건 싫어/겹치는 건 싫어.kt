import kotlin.math.max

val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    val a = br.readLine().split(" ").map { it.toInt() }
    val map = mutableMapOf<Int, Int>()
    var max = 0
    var left = 0

    for(i in 0 until n) {
        map[a[i]] = map.getOrDefault(a[i],0) +1

        while(map[a[i]]!!> k) {
            map[a[left]] = map.getOrDefault(a[left],0) - 1
            left++
        }

        max = max(max, i-left+1)
    }

    write("$max")
    close()
}