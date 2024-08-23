val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val word = br.readLine()
    val map = HashMap<Char, Int>()
    for(i in word) {
        map[i.uppercaseChar()] = map.getOrDefault(i.uppercaseChar(),0) + 1
    }

    val sortedEntries = map.entries.sortedByDescending { it.value }

    if(sortedEntries.size < 2) {
        print(sortedEntries[0].key)
    } else {
        if(sortedEntries[0].value == sortedEntries[1].value) {
            print("?")
        } else {
            print(sortedEntries[0].key)
        }
    }


    close()
}