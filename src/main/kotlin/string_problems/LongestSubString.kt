package string_problems


import kotlin.math.max

class LongestSubString {
    fun lenOfLongestSubString(s: String): Int{
        //val charTable = Array(128) { 0 }
        //val chars = arrayOfNulls<Int>(128)

        val charMap = mutableMapOf<Char, Int>()

        var leftPtr = 0

        var longestSubStr = 0

        for(rightPtr in s.indices){
            //val p: Int = s[0].code // this is the same as converting to int .toInt(), toInt() is deprecated
            println("Code: currently at for loop -> char: ${s[rightPtr]}, rightPtr: $rightPtr")
            if(charMap.containsKey(s[rightPtr])){ //means we saw current character before, so we move leftPtr to one char after the char we saw
                println("Code: currently at if block -> max(${charMap[s[rightPtr]]!!}, $leftPtr)")
                leftPtr = max(charMap[s[rightPtr]]!!, leftPtr)
            }
            longestSubStr = max(longestSubStr, rightPtr - leftPtr + 1) // we add 1 here since indexes are 0 based.
            charMap[s[rightPtr]] = rightPtr + 1 // we add 1 here in order to begin at the character after the first occurrence of a duplicate.
        }

        println("**********************")
        for((k,v) in charMap){
            println("key: $k, value: $v")
        }

        return longestSubStr
    }
}

fun testLongestSubstring(){
    val sp = LongestSubString()
    val result = sp.lenOfLongestSubString("abcdeafbdgcbb")
    println(result)
}