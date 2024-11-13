import kotlin.math.*

class Solution {
    fun solution(numbers: IntArray, hand: String): String {
        var answer = ""
        var lX = 3
        var lY = 0
        var rX = 3
        var rY = 2
        val hand = hand[0].toUpperCase()
        
        for(i in numbers) {
            when(i) {
                1 -> {
                    lX = 0
                    lY = 0
                    answer+='L'
                }
                4 -> {
                    lX = 1
                    lY = 0
                    answer+='L'
                }
                7 -> {
                    lX = 2
                    lY = 0
                    answer+='L'
                }
                3 -> {
                    rX = 0
                    rY = 2
                    answer+='R'
                }
                6 -> {
                    rX = 1
                    rY = 2
                    answer+='R'
                }
                9 -> {
                    rX = 2
                    rY = 2
                    answer+='R'
                }
                2 -> {
                   if(abs(lX-0) + abs(lY-1) > abs(rX-0) + abs(rY-1)) {
                       answer+='R'
                       rX = 0
                       rY = 1
                   } else if (abs(lX-0) + abs(lY-1) < abs(rX-0) + abs(rY-1)) {
                       answer+='L'
                       lX = 0
                       lY = 1
                   } else {
                       answer+= hand
                       if (hand == 'R') {
                            rX = 0
                            rY = 1
                        } else {
                            lX = 0
                            lY = 1
                        }
                   }
                }
                5 -> {
                    if(abs(lX-1) + abs(lY-1) > abs(rX-1) + abs(rY-1)) {
                       answer+='R'
                        rX = 1
                       rY = 1
                   } else if (abs(lX-1) + abs(lY-1) < abs(rX-1) + abs(rY-1)) {
                       answer+='L'
                        lX = 1
                       lY = 1
                   } else {
                       answer+= hand
                        if (hand == 'R') {
                            rX = 1
                            rY = 1
                        } else {
                            lX = 1
                            lY = 1
                        }
                   }
                }
                8 -> {
                     if(abs(lX-2) + abs(lY-1) > abs(rX-2) + abs(rY-1)) {
                       answer+='R'
                         rX = 2
                       rY = 1
                   } else if (abs(lX-2) + abs(lY-1) < abs(rX-2) + abs(rY-1)) {
                       answer+='L'
                         lX = 2
                       lY = 1
                   } else {
                       answer+= hand
                         if (hand == 'R') {
                            rX = 2
                            rY = 1
                        } else {
                            lX = 2
                            lY = 1
                        }
                   }
                }
                0 -> {
                      if(abs(lX-3) + abs(lY-1) > abs(rX-3) + abs(rY-1)) {
                       answer+='R'
                          rX = 3
                       rY = 1
                   } else if (abs(lX-3) + abs(lY-1) < abs(rX-3) + abs(rY-1)) {
                       answer+='L'
                          lX = 3
                       lY = 1
                   } else {
                       answer+= hand
                          if (hand == 'R') {
                            rX = 3
                            rY = 1
                        } else {
                            lX = 3
                            lY = 1
                        }
                   }
                }
            }
        }
        return answer
    }
}