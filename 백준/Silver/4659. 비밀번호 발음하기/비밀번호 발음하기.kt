val br = System.`in`.bufferedReader()
val vowels = listOf('a','e','i','o','u')

fun main() = with(System.out.bufferedWriter()) {
    while(true) {
        val word = br.readLine()
        var count = 1
        var flag = false

        if(word == "end") {
            break
        }

        for(i in word.indices) {
            if(isVowel(word[i])) flag = true

            if(i!= 0) {
                if(isVowel(word[i]) == isVowel(word[i-1])) {
                    count++
                } else {
                    count = 1
                }

                if(count>2) {
                    flag = false
                    break
                }

                if(word[i-1] == word[i] && (word[i] != 'e' && word[i] !='o')) {
                    flag = false
                    break
                }
            }
        }

        if(flag) {
            write("<$word> is acceptable.\n")
        } else {
            write("<$word> is not acceptable.\n")
        }
    }
    close()
}

fun isVowel(alpha: Char): Boolean {
    return vowels.contains(alpha)
}