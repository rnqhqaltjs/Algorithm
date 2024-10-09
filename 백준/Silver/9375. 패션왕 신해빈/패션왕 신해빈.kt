val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val t = br.readLine().toInt()

    repeat(t) {
        val n = br.readLine().toInt()
        val hashmap = mutableMapOf<String, Int>()
        var sum = 1

        repeat(n) {
            val (a, b) = br.readLine().split(" ")

            hashmap[b] = hashmap.getOrDefault(b, 0) + 1
        }

        for (i in hashmap.values) {
            sum *= (i + 1)
        }

        write("${sum - 1}\n")
    }
    
    close()
}