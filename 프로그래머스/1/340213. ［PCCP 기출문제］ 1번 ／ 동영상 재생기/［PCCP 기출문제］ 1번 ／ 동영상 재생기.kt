class Solution {
    fun solution(video_len: String, pos: String, op_start: String, op_end: String, commands: Array<String>): String {
        var answer: String = ""
        var (min, sec) = pos.split(':').map { it.toInt() }
        var (sMin, sSec) = op_start.split(':').map { it.toInt() }
        var (eMin, eSec) = op_end.split(':').map { it.toInt() }
        var (vMin, vSec) = video_len.split(':').map { it.toInt() }
        
        var currentTime = min * 60 + sec
        var videoTime = vMin * 60 + vSec
        var startOpTime = sMin * 60 + sSec
        var endOpTime = eMin * 60 + eSec
        
        if(currentTime >= startOpTime && currentTime <= endOpTime) {
            currentTime = endOpTime
        }
        
        for(i in commands) {
            when(i) {
                "next" -> {
                    currentTime += 10
                    
                    if(currentTime>=videoTime) {
                        currentTime = videoTime
                    }
                    
                    if(currentTime >= startOpTime && currentTime <= endOpTime) {
                        currentTime = endOpTime
                    }
                }
                "prev" -> {
                    currentTime -=10
                    
                    if(currentTime<=0) {
                        currentTime = 0
                    }
                    
                    if(currentTime >= startOpTime && currentTime <= endOpTime) {
                        currentTime = endOpTime
                    }
                }
            }
        }
        return String.format("%02d:%02d", currentTime/60, currentTime%60)
    }
}