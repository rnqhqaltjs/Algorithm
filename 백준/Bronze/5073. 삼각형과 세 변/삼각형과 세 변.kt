val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    while(true) {
        val (x, y, z) = br.readLine().split(" ").map { it.toInt() }

        if(x==0) break

        val list = mutableListOf(x,y,z)
        list.sort()

        val a = list[0]
        val b = list[1]
        val c = list[2]

        if(a+b<=c) {
            println("Invalid")
        } else if (a==b && b==c) {
            println("Equilateral")
        } else if (a==b || b==c || c==a) {
            println("Isosceles")
        } else {
            println("Scalene")
        }
    }


    close()
}