val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (n,x) = br.readLine().split(" ").map { it.toInt() }

    val array = br.readLine().split(" ").map { it.toInt() }
    var max = 0
    var sum = 0
    var count = 1

    for(i in 0 until x) {
        sum += array[i]
        max = sum
    }

    for(i in 0 until n - x) {
        sum = sum - array[i] + array[i + x]

        if(max == sum) {
            count++
        }
        if(sum> max) {
            max = sum
            count = 1
        }
    }

    if(max != 0) {
        write("$max\n$count")
    } else {
        write("SAD")
    }
    
    close()
}