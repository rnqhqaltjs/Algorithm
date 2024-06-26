val br = System.`in`.bufferedReader()

fun main() =with(System.out.bufferedWriter()){

    var (n, k) = br.readLine().split(' ').map { it.toInt() }
    val list = mutableListOf<Int>()

    for(i in 0 until n) {
        val a = br.readLine().toInt()
        list.add(a)
    }
    list.sortDescending()

    var answer = 0
    for(i in list) {
        if(k>=i) {
            answer += k/i
            k %= i
            if(k<=0) {
                break
            }
        }
    }

    write(answer.toString())
    close()
}