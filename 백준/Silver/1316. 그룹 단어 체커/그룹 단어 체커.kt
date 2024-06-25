fun main(){

    val n = readln().toInt()
    var count = 0

    for(i in 0 until n) {
        val word = readln()
        var last = ' '
        val charSet = mutableSetOf<Char>()
        var isGroupWord = true


        for(j in word.indices) {
            if(last != word[j]) {
                last = word[j]

                if (!charSet.add(word[j])) {
                    isGroupWord = false
                }

            }
        }
        if (isGroupWord) {
            count++
        }
    }
    println(count)
}