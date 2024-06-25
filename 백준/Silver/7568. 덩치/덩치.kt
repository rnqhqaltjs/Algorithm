fun main(){

    val n = readln().toInt()
    val m = mutableListOf<Pair<Int, Int>>()


    for(i in 0 until n) {
        val (key, value) = readln().split(" ").map { it.toInt() }
        m.add(Pair(key, value))
    }

    m.forEach {
        var count = 1
        m.forEach { current ->
            if(it.first < current.first && it.second < current.second) {
                count ++
            }
        }
        print("$count ")
    }
}