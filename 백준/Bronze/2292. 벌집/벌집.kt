val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val x = br.readLine().toInt()
    var result = 1
    var room = 1

    if(x==1) {
        print(result)
    } else {
        while(room <x) {
            room += result * 6
            result++
        }
        print(result)
    }
    close()
}