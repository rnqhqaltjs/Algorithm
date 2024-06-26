val br = System.`in`.bufferedReader()

fun main() =with(System.out.bufferedWriter()){

    val n = br.readLine().toInt()
    val m = br.readLine().split(' ').map { it.toInt() }
    val list = m.distinct().sorted()

    for(i in 0 until n) {
        write("${list.binarySearch(m[i])} ")
    }
    
    close()
}