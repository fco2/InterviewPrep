package grokking_algos

import kotlin.math.min

class SmallestSubArray {
    fun solution(S: Int, arr: IntArray): Int{
        var minLength = Int.MAX_VALUE
        var windowStart = 0
        var windowSum = 0

        for(windowEnd in arr.indices){
            windowSum += arr[windowEnd]

            while(windowSum >= S && windowStart < arr.size){
                //get current min length
                minLength = min(minLength, windowEnd - windowStart + 1)
                //remove left most element, increment windowStart
                windowSum -= arr[windowStart]
                windowStart++
            }
        }
        return if(minLength == Int.MAX_VALUE) 0 else minLength
    }
}

fun testSmallestSubArray(){
    val ss = SmallestSubArray()
    var arr = intArrayOf(2,1,5,2,3,2)
    var result = ss.solution(7, arr)
    println(result)

    arr = intArrayOf(2,1,5,2,8)
    result = ss.solution(7, arr)
    println(result)
}