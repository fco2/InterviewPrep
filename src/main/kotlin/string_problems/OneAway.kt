package string_problems


class OneAway {

    //print a concat of matching strings or print INVALID_MATCH
    fun oneEditAway(s1: String, s2: String): String {
        return if(s1.length == s2.length){// this is one edit replace away
            oneEditReplaceAway(s1, s2)
        } else if(s1.length + 1 == s2.length){ // means s1 is smaller
            oneEditInsertionAway(s1, s2)
        }else if(s1.length - 1 == s2.length){ // s2 > s1
            oneEditInsertionAway(s2, s1)
        } else{
            "INVALID_MATCH"
        }
    }

    private fun oneEditReplaceAway(s1: String, s2: String): String{
        var foundTheDifference = false
        var indexOfFoundDiff = -1 //Int.MAX_VALUE
        var result = ""

        for(index in s1.indices){
            if(s1[index] != s2[index]){// we found a difference
                if(foundTheDifference) {//means this is our second difference
                    return "INVALID_MATCH"
                }
                foundTheDifference = true
                indexOfFoundDiff = index
            }
        }
        if(indexOfFoundDiff != -1){
            val sb = StringBuilder(s1).also{ it.setCharAt(indexOfFoundDiff, s2[indexOfFoundDiff])}
            val newS1 = sb.toString()
            result = "$newS1 | $s2"
        }
        return result
    }

    private fun oneEditInsertionAway(s1: String, s2: String): String{
       // val arr = arrayOf(1, 3, 2)
       // Arrays.sort(arr)

        var index1 = 0
        var index2 = 0
        //abcd
        //abce
        var foundDiff = false
        var diffIndex = -1
        var result = ""
        val sb = StringBuilder()

        while(index1 < s1.length && index2 < s2.length){
            if(s1[index1] != s2[index2]){ // we found a diff
                println("Diff:  ${s1[index1] }, ${s2[index2]}")
                if(foundDiff){ // if this is the second difference found
                    println("From here: ${s1[index1] }, ${s2[index2]}")
                    return "INVALID_MATCH"
                }
                foundDiff = true
                diffIndex = index1
                index2++
            } else{ // go to next iteration
                index1++
                index2++
            }
        }
        if(diffIndex != -1){ //means we found a match
            //string.substring() functions are 1 indexed , so
            sb.append(s1.substring(0, diffIndex))
            sb.append(s2[diffIndex])
            sb.append(s1.substring(diffIndex))

            //println("substrings: ${s1.substring(0, diffIndex )} | ${s2[diffIndex]} | ${s1.substring(diffIndex + 1)} | $diffIndex")
            result = "${sb.toString()} | $s2"
        }
        else{
            return "${sb.append(s1).append(s2[s2.length - 1])} | $s2"
        }
        println(diffIndex)
        return result
    }
}

fun testOneEditAway(){
    val oa = OneAway()
    val result = oa.oneEditAway("Chuka", "Chubd")
    println(result)
}

//internal class Pair(var first: Int, var second: Int)


class LinkedList {
    var head : Node? = null // head of list

    /* Node Class */
    // Constructor to create a new node
    class Node (var data: Int) {
        var next: Node? = null
    }
}