package grokking_algos


class AllAnagramsOfPattern {
    fun solution(str: String, pattern: String): MutableList<Int>{
        val charFreqMap = mutableMapOf<Char, Int>()
        var windowStart = 0
        var matchedChars = 0
        val resultIndicesList = mutableListOf<Int>()
        //populate character freq map
        for(index in pattern.indices){
            val key = pattern[index]
            charFreqMap[key] = charFreqMap.getOrDefault(key, 0) + 1
        }
        //loop through str characters
        for(windowEnd in str.indices){
            val rightChar = str[windowEnd]
            if(charFreqMap.contains(rightChar)){ // then we reduce the frequency of it in map
                charFreqMap[rightChar] = charFreqMap.getOrDefault(rightChar, 0) - 1
                //check if this char has been fully matched
                if(charFreqMap[rightChar] == 0)
                    matchedChars++
            }

            if(matchedChars == charFreqMap.size) {
                resultIndicesList.add(windowStart) // a permutation was found here
                //for testing
                for(index in windowStart..windowEnd){
                    print("${str[index]}")
                    if(index < windowEnd)
                        print(" -> ")
                }
                println()
            }
            // check if the window size is greater than pattern, then we shrink the window by moving windowStart to the right by 1
            if(windowEnd >= pattern.length - 1){
                val leftChar = str[windowStart]
                windowStart++
                //because we are leaving leftChar in the dust, we need to check if it was totally matched, means we don't need it at all
                if(charFreqMap[leftChar] == 0){
                    matchedChars--
                }
                //add the char back because it was removed for matching above.
                charFreqMap[leftChar] = charFreqMap.getOrDefault(leftChar, 0) + 1
            }
        }
        return resultIndicesList
    }
}

fun testAllAnagramsOfPattern(){
    val aaop = AllAnagramsOfPattern()
    var str = "ppqp"
    var pattern = "pq"
    var result = aaop.solution(str, pattern)
    println(result)

    str = "abbcabc"
    pattern = "bca"
    result = aaop.solution(str, pattern)
    println(result)
}