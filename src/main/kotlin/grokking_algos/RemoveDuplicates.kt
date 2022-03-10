package grokking_algos


class RemoveDuplicates {

    fun solution(arr: IntArray){
        var windowStart = 1
        for(windowEnd in 1 until arr.size){
            //notice that windowStart never changes until we meet a new character
            if(arr[windowStart - 1] != arr[windowEnd]){
                arr[windowStart] = arr[windowEnd]
                windowStart++
            }
        }

        for(index in 0 until windowStart){
            print("${arr[index]}")
            if(index < windowStart - 1)
                print(" -> ")
        }
        println()
    }
}

fun testRemoveDuplicates(){
    val rd = RemoveDuplicates()
    var arr = intArrayOf(2, 3, 3, 3, 6, 9, 9)
    rd.solution(arr)
    arr = intArrayOf(2,2,2,11)
    rd.solution(arr)
}