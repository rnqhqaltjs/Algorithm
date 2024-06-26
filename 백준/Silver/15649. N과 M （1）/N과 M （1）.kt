val br = System.`in`.bufferedReader()

fun main() =with(System.out.bufferedWriter()){
    val (n, m) = br.readLine().split(' ').map { it.toInt() }

    val array = IntArray(m)
    val isVisited = BooleanArray(n+1) { false }

    fun permutation(depth: Int) {
        if (depth == m) {
            array.forEach {
                print("$it ")
            }
            println()
            return
        }
        for(i in 1 .. n) {

            if(!isVisited[i]) {
                isVisited[i] = true
                array[depth] = i
                permutation(depth+1)
                isVisited[i] = false
            }
        }
    }


    permutation(0)
    close()
}


