val mbti = arrayOf('R', 'T', 'C', 'F', 'J', 'M' , 'A', 'N')

class Solution {
    fun solution(survey: Array<String>, choices: IntArray): String {
        var answer: String = ""
        val map = mutableMapOf<Char,Int>()
        
        for(i in mbti) {
            map[i] = 0
        }
        
        for(i in survey.indices) {
            when(choices[i]) {
                1 -> {
                    map[survey[i][0]] = map.getOrDefault(survey[i][0],0) + 3
                }
                2 -> {
                    map[survey[i][0]] = map.getOrDefault(survey[i][0],0) + 2
                }
                3 -> {
                    map[survey[i][0]] = map.getOrDefault(survey[i][0],0) + 1
                }
                5 -> {
                    map[survey[i][1]] = map.getOrDefault(survey[i][1],0) + 1
                }
                6 -> {
                    map[survey[i][1]] = map.getOrDefault(survey[i][1],0) + 2
                }
                7 -> {
                    map[survey[i][1]] = map.getOrDefault(survey[i][1],0) + 3
                }
            }
        }
        
        if(map.getOrDefault('R',0) > map.getOrDefault('T',0)) {
            answer+='R'
        } else if (map.getOrDefault('R',0) < map.getOrDefault('T',0)) {
            answer+='T'
        } else {
            answer+='R'
        }
        
        if(map.getOrDefault('C',0) > map.getOrDefault('F',0)) {
            answer+='C'
        } else if (map.getOrDefault('C',0) < map.getOrDefault('F',0)) {
            answer+='F'
        } else {
            answer+='C'
        }
        
        if(map.getOrDefault('J',0) > map.getOrDefault('M',0)) {
            answer+='J'
        } else if (map.getOrDefault('J',0) < map.getOrDefault('M',0)) {
            answer+='M'
        } else {
            answer+='J'
        }
        
        if(map.getOrDefault('A',0) > map.getOrDefault('N',0)) {
            answer+='A'
        } else if (map.getOrDefault('A',0) < map.getOrDefault('N',0)) {
            answer+='N'
        } else {
            answer+='A'
        }
        
        return answer
    }
}