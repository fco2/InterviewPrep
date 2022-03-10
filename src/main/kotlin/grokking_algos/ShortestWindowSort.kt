package grokking_algos

import kotlin.math.max
import kotlin.math.min

class ShortestWindowSort {
    fun solution(arr: IntArray): Int{
        var low = 0
        var high = arr.size - 1
        while(low < arr.size - 1 && arr[low] <= arr[low + 1])
            low++

        if(low == arr.size - 1)
            return 0

        while(high > 0 && arr[high] >= arr[high - 1])
            high--

        var currentMin = Int.MAX_VALUE
        var currentMax = Int.MIN_VALUE
        var index = low
        while(index <= high){
            currentMin = min(currentMin, arr[index])
            currentMax = max(currentMax, arr[index])
            index++
        }
        //get the new min
        while(low > 0 && arr[low - 1] > currentMin) // it's low - 1 because we already processed low during the above while window
            low--
        //get new max
        while(high < arr.size - 1 && arr[high + 1] < currentMax)   // 1,[5,4,3],5,6
            high++ // increase the window
        //print arr
        println("Array:")
        arr.forEachIndexed{index, item ->
            print(item)
            if(index < arr.size - 1)
                print(", ")
        }
        println()
        return high - low + 1 // +1 because it's 0 indexed.
    }
}

fun testShortestWindowSort(){
    val sws = ShortestWindowSort()

    println("Size: ${sws.solution(intArrayOf(1,2,3))}")

    println("Size: ${sws.solution(intArrayOf(1,2,5,3,7,10,9,12))}")

    println("Size: ${sws.solution(intArrayOf(1,3,2,0,-1,7,10))}")
}