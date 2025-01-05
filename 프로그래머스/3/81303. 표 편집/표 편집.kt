import java.util.*

class Solution {
    fun solution(n: Int, k: Int, cmd: Array<String>): String {
        var answer = ""
        var k = k
        val tempDeleted = Stack<Int>()
        var tableSize = n
        
        for(i in cmd) {
            val input = i.split(" ")
        
            when(input[0]) {
                "D" -> {
                    k += input[1].toInt()
                }

                "U" -> {
                    k -= input[1].toInt()
                }

                "C" -> {
                    tableSize--
                    tempDeleted.push(k)
                    if(tableSize == k) {
                        k--
                    }
                }

                "Z" -> {
                    tableSize++
                    if(tempDeleted.pop() <= k) {
                        k++
                    }
                }
            }
        }
        
        val sb = StringBuilder()
        sb.append("O".repeat(tableSize))
        
        while (tempDeleted.isNotEmpty()) {
            sb.insert(tempDeleted.pop(), 'X')
        }

        return sb.toString()
    }
}