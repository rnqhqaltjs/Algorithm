val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val n = br.readLine().toInt()
    val word = br.readLine()
    val wordList = mutableListOf<Char>()
    var count = 0

    for(i in word) {
        wordList.add(i)
    }

    repeat(n-1) {
        val compareWord = br.readLine()
        val compareWordList = mutableListOf<Char>()
        var wrong = 0

        for(i in compareWord) {
            compareWordList.add(i)
        }

        for(i in wordList) {
            if(i in compareWordList) {
                compareWordList.remove(i)
            } else {
                wrong++
            }
        }

        if(wrong<2 && compareWordList.size<2) {
            count++
        }
    }

    write("$count")

    close()
}
