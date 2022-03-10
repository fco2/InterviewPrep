package string_problems

class StringCompression {

    fun compress(chars: CharArray): Int{
        var count = 1
        val sb = StringBuilder()
        var currentChar = chars[0]

        for(index in 1 until chars.size){
            if(chars[index] == currentChar){
                count++
            }else{
                sb.append(currentChar)
                if(count != 1)
                    sb.append(count)
                currentChar = chars[index]
                count = 1
            }
        }
        //if we are iterating over a single item array
        if(count == 1)
            sb.append(currentChar)
        else{
            sb.append(currentChar)
            sb.append(count)
        }
        println(sb.toString())

        val strResult = sb.toString()
        strResult.forEachIndexed{index, value ->
            chars[index] = value
        }
        return strResult.length
    }
}

fun testCompress() {
    val sc = StringCompression()
    val chars = "abbbbbbbbbbbb".toCharArray() // aabbccc, a,
    sc.compress(chars)
}