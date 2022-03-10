package grokking_algos

class BackspaceCompare {
    fun solution(str1: String, str2: String): Boolean{
        var index1 = str1.length - 1
        var index2 = str2.length - 1

        while(index1 >= 0 || index2 >= 0){
            val nextValidIndex1 = getNextValidIndex(str1, index1)
            val nextValidIndex2 = getNextValidIndex(str2, index2)

            if(nextValidIndex1 < 0 && nextValidIndex2 < 0)
                return true
            if(nextValidIndex1 < 0 || nextValidIndex2 < 0)
                return false

            if(str1[nextValidIndex1] != str2[nextValidIndex2]) // found a diff
                return false
            //decrement indexes
            index1 = nextValidIndex1 - 1
            index2 = nextValidIndex2 - 1
        }
        return true
    }

    private fun getNextValidIndex(str: String, index: Int): Int {
        var specialCharCount = 0
        var currentIndex = index
        while(currentIndex >= 0){
            if(str[currentIndex] == '#')
                specialCharCount++
            else if(specialCharCount > 0) // skip the next char as it is part of the special char
                specialCharCount--
            else
                break
            currentIndex--
        }
        return currentIndex
    }
}

fun testBackSpaceCompare(){
    val bc = BackspaceCompare()
    var str1 = "xy#z"
    var str2 = "xzz#"

    println("For str1: $str1 and str2: $str2 , result: ${bc.solution(str1, str2)}")

    str1 = "xy#z"
    str2 = "xyz#"
    println()
    println("For str1: $str1 and str2: $str2 , result: ${bc.solution(str1, str2)}")

    str1 = "xp#"
    str2 = "xyz##"
    println()
    println("For str1: $str1 and str2: $str2 , result: ${bc.solution(str1, str2)}")

    str1 = "xywrrmp"
    str2 = "xywrrmu#p"
    println()
    println("For str1: $str1 and str2: $str2 , result: ${bc.solution(str1, str2)}")
}