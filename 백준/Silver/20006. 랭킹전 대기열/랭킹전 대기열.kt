import kotlin.math.abs

val br = System.`in`.bufferedReader()

fun main() = with(System.out.bufferedWriter()) {
    val (p, m) = br.readLine().split(" ").map { it.toInt() }
    val rooms = mutableListOf<MutableList<Pair<Int, String>>>()

    var idx = 0
    repeat(p) {
        val (l, n) = br.readLine().split(" ")
        var isValid = false
        val level = l.toInt()

        for (room in rooms) {
            if (room.isNotEmpty() && abs(room[0].first - level) <= 10 && room.size < m) {
                room.add(Pair(level, n))
                isValid = true
                break
            }
        }

        if(!isValid) {
            rooms.add(mutableListOf(Pair(level, n)))
            idx++
        }
    }

    for (room in rooms) {
        if (room.size == m) {
            write("Started!\n")
        } else {
            write("Waiting!\n")
        }
        
        room.sortBy { it.second }
        for (player in room) {
            write("${player.first} ${player.second}\n")
        }
    }

    close()
}