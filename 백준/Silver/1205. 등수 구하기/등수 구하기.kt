val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (n, s, p) = br.readLine().split(" ").map { it.toInt() }
    var score = listOf<Int>()
    if(n>0){
        score = br.readLine().split(" ").map { it.toInt() }
    }
    var rank = n+1

    if(n == 0) {
        write("1")
    } else if(score[n-1]>=s && n == p) {
        write("-1")
    } else {
        for(i in 0 until n) {
            if(s>=score[i]) {
                rank = i+1
                break
            }
        }
        write("$rank")
    }

    close()
}