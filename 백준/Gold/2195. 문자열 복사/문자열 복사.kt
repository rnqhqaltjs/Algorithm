val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val s = br.readLine()
    val p = br.readLine()

    var i = 0
    var count = 0
    while(i < p.length) {
        var length = 0
        for(j in s.indices) {
            var temp = 0
            while (j + temp < s.length && i + temp < p.length && s[j + temp] == p[i + temp]) {
                temp++
            }
            if(temp> length) {
                length = temp
            }
        }
        i +=length
        count++
    }

    write("$count")
    close()
}