class Solution {
    fun solution(quiz: Array<String>): Array<String> {
        var list: List<String> = emptyList<String>()
        var answer: Array<String> = arrayOf<String>()
        for(i in quiz) {
            list = i.split(" ")
            if(list[1] == "+") {
                if(list[0].toInt() + list[2].toInt() == list[4].toInt()) {
                    answer+="O"
                } else {
                    answer+="X"
                }
            } else {
                if(list[0].toInt() - list[2].toInt() == list[4].toInt()) {
                    answer+="O"
                } else {
                    answer+="X"
                }
            }
            
        }
        return answer
    }
}