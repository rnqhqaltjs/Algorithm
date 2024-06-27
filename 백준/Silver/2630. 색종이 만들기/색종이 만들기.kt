val br = System.`in`.bufferedReader()

fun main() =with(System.out.bufferedWriter()){

    val n = br.readLine().toInt()
    val array = Array(n) {IntArray(n) {0} }

    var blue = 0
    var white = 0

    for(i in 0 until n) {
        array[i] =  br.readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    fun check(size:Int, x:Int, y:Int): Boolean {
        val paper = array[x][y]
        for(i in x until x+size) {
            for(j in y until y+size) {
                if(array[i][j] != paper) return false
            }
        }

        return true
    }

    fun divide(size: Int, x: Int, y: Int) {
        if (size == 1 || check(size, x, y)) {
            if(array[x][y] == 1) blue ++
            else white ++
        } else {
            divide(size/2, x, y)
            divide(size/2, x + size/2, y)
            divide(size/2, x, y + size/2)
            divide(size/2, x + size/2, y + size/2)
        }
    }


    divide(n, 0, 0)

    write("${white}\n${blue}")
    close()
}