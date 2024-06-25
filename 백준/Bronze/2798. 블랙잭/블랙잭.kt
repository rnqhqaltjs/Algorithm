fun main(){

    val n = readln().split(" ").map { it.toInt() }
    val cardNum = readln().split(" ").map { it.toInt() }

    var sum = 0

    for(i in cardNum.indices) {
        for(j in i+1 until cardNum.size) {
            for(k in j+1 until cardNum.size) {
                val cardSum = cardNum[i] + cardNum[j]+ cardNum[k]
                if(cardSum <=n[1]) {
                    if(cardSum> sum) {
                        sum = cardSum
                    }
                }
            }
        }
    }
    
    println(sum)


}