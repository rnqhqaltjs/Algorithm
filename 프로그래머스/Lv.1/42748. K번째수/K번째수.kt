class Solution {
    fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
        var answer = intArrayOf()
        for(i in commands.indices) {
            answer+=array.slice(commands[i][0]-1..commands[i][1]-1).sorted()[commands[i][2] - 1]
        }
        return answer
    }
}