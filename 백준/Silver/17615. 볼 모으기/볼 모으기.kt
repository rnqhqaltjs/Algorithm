val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val n = br.readLine().toInt()

    val balls = br.readLine()
    var redCount = 0
    var blueCount = 0
    var redFirst = 0
    var blueFirst = 0
    var redLast = 0
    var blueLast = 0
    var answer = Int.MAX_VALUE

    for(i in balls.indices) {
        if(balls[i] == 'R') {
            redCount++
        }
        if(balls[i] == 'B') {
            blueCount++
        }
    }

    for(i in balls.indices) {
        if(balls[i] == 'R') {
            redFirst++
        } else {
            break
        }
    }

    for(i in balls.indices) {
        if(balls[i] == 'B') {
            blueFirst++
        } else {
            break
        }
    }

    for(i in balls.length -1 downTo  0) {
        if(balls[i] == 'R') {
            redLast++
        } else {
            break
        }
    }

    for(i in balls.length -1 downTo  0) {
        if(balls[i] == 'B') {
            blueLast++
        } else {
            break
        }
    }

    answer = minOf(redCount - redFirst, answer)
    answer = minOf(redCount - redLast, answer)
    answer = minOf(blueCount - blueLast, answer)
    answer = minOf(blueCount - blueFirst, answer)


    write("$answer")
    close()
}