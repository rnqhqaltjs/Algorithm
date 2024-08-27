val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val n = br.readLine().toInt()
    val array = Array(n) { CharArray(n)}
    var x = 0
    var y = 0
    var leftArm = 0
    var rightArm = 0
    var back = 0
    var leftLeg = 0
    var rightLeg = 0

    for(i in 0 until n) {
        array[i] = br.readLine().toCharArray()
    }

    loop@for(i in 0 until n ){
        for(j in 0 until n) {
            if(array[i][j] == '*') {
                x = i+1
                y = j
                break@loop
            }
        }
    }

    for(i in 0 until y) {
        if(array[x][i] == '*') {
            leftArm++
        }
    }

    for(i in y+1 until n) {
        if(array[x][i] == '*') {
            rightArm++
        }
    }

    for(i in x+1 until n ) {
        if(array[i][y] == '*') {
            back++
        }
    }

    for(i in x+1+back until n) {
        if(array[i][y-1] == '*') {
            leftLeg++
        }
    }

    for(i in x+1+back until n) {
        if(array[i][y+1] == '*') {
            rightLeg++
        }
    }

    write("${x+1} ${y+1}\n")
    write("$leftArm $rightArm $back $leftLeg $rightLeg")
    close()
}