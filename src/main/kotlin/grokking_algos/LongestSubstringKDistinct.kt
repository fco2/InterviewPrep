package grokking_algos

import kotlin.math.max

class LongestSubstringKDistinct {

    fun solution(str: String?, k: Int): Int{
        //validate input
        if((str == null) || (str == "") || (k > str.length))
            throw IllegalArgumentException()

        var windowStart = 0
        var maxDistinct = 0
        val distinctCharFreqMap = mutableMapOf<Char, Int>()

        for(windowEnd in str.indices){
            var count = distinctCharFreqMap.getOrDefault(str[windowEnd], 0)
            distinctCharFreqMap[str[windowEnd]] = count + 1 //only non-null calls are allowed in a nullable receiver

            while(distinctCharFreqMap.size > k){
                //first remove current char from the start of window
                count = distinctCharFreqMap.getOrDefault(str[windowStart], 0)
                distinctCharFreqMap[str[windowStart]] = count - 1
                if(distinctCharFreqMap[str[windowStart]] == 0){
                    //means we no longer have occurrence of that char in our map, we remove that map entry
                    distinctCharFreqMap.remove(str[windowStart])
                }
                windowStart++
            }
            maxDistinct = max(maxDistinct, windowEnd - windowStart + 1)
        }
        return maxDistinct
    }
}

fun testLongestSubstringKDistinct(){
    val lsd = LongestSubstringKDistinct()
    var str = "araaci"
    println(lsd.solution(str, 2))

    println(lsd.solution(str, 1))

    str = "cbbebi"
    println(lsd.solution(str, 3))
}