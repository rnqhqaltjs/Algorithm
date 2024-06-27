val br = System.`in`.bufferedReader()

fun main() =with(System.out.bufferedWriter()){

    val n = br.readLine().toInt()
    val x = br.readLine().split(" ").map { it.toInt() }.sorted()
    val m = br.readLine().toInt()
    val y = br.readLine().split(" ").map { it.toInt() }

    for(i in 0 until m) {
        if(x.binarySearch(y[i]) >= 0) {
            write("${1}\n")
        } else {
            write("${0}\n")
        }
    }


    close()
}