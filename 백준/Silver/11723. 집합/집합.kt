val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val n = br.readLine().toInt()
    val hashSet = hashSetOf<Int>()

    repeat(n) {
        val x = br.readLine().split(" ")
        var num = 0

        if(x[0] != "empty" && x[0] != "all") {
            num = x[1].toInt()
        }

        when(x[0]) {
            "add" -> {
                hashSet.add(num)
            }
            "remove" -> {
                hashSet.remove(num)
            }
            "check" -> {
                if(hashSet.contains(num)) {
                    write("1\n")
                } else {
                    write("0\n")
                }
            }
            "toggle" -> {
                if(hashSet.contains(num)) {
                    hashSet.remove(num)
                } else {
                    hashSet.add(num)
                }
            }
            "all" -> {
                for(i in 1 .. 20) {
                    if(!hashSet.contains(i)) {
                        hashSet.add(i)
                    }
                }
            }
            "empty" -> {
                hashSet.clear()
            }
        }
    }

    close()
}