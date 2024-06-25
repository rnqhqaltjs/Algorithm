fun main(){

    val n = readln().toInt()
    var count = 0

    for(i in 0 until n) {
        val word = readln()
        var last = ' '
        var isGroupWord = true


        for(j in word.indices) {
            if(last != word[j]) {
                last = word[j]

                for (k in 0 until j) {
                    if (word[k] == word[j]) {
                        isGroupWord = false
                        break
                    }
                }
            }
        }
        if (isGroupWord) {
            count++
        }
    }
    println(count)
}