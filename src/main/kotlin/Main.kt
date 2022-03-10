import grokking_algos.testBackSpaceCompare
import grokking_algos.testDutchNationalFlag
import grokking_algos.testShortestWindowSort
import string_problems.testThreeSums

fun main(args: Array<String>) {
    //testLinkedList()
    //testLinkedList2()
    //testLongestSubstring()
    //testMaxArea()
    //testThreeSums()
    //testAddTwoStrings()
    //testIsValid()
    //testOneEditAway()
    //testCompress()
    //testFindTriplets()
    //testFind3Numbers()
    //testSmallestWindow()
    //testMaximumEvents()
    //testSmallestSubArray()
    //testLongestSubstringKDistinct()
    //testAllAnagramsOfPattern()
    //testRemoveDuplicates()
    //testAssignment()
    //testTopTalAssignment()
    //testDutchNationalFlag()
    //testBackSpaceCompare()
    testShortestWindowSort()

    //TODO: hashMaps
   /* val test = mutableMapOf<String, Int>()
    test["Hello"] = 1
    test["Hello"] = test["Hello"]!!.plus(1) // nullable type
    for((key, value) in test){
        println("$key, $value")
    }
    val arr = arrayOf("apple", "banana", "grape")
    for(index in arr.indices){
        println("$index, ${arr[index]}")
    } */

    //TODO: replace character of string
   /* val s1 = "Hello"
    //using StringBuilder
    val sb = StringBuilder(s1).also{ it.setCharAt(2, 'X') }
    println(sb.toString())
    //using character array
    val ca = s1.toCharArray()
    ca[3] = 'B'
    val s = String(ca)
    println(s)
    println("############")
    //Returns the substring of this string starting at the startIndex and ending right before the endIndex.
    println("Hello".substring(0, 3)) // startIndex and endIndex, it excludes the end index
    println("Hello".substring(3)) // without end index, it goes to the remainder of the string
    */
}


