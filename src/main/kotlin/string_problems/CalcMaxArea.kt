package string_problems


import kotlin.math.max
import kotlin.math.min

class CalcMaxArea {

    fun maxArea(arr: Array<Int>): Int{
        var max = 0
        var leftPtr = 0
        var rightPtr = arr.size - 1 //length is for only string

        while(leftPtr < rightPtr){
            val currentArea = min(arr[leftPtr], arr[rightPtr]) * (rightPtr - leftPtr)
            max = max(max, currentArea)

            if(arr[leftPtr] < arr[rightPtr])
                leftPtr++
            else
                rightPtr--
        }
        return max
    }
}

fun testMaxArea(){
    val cma = CalcMaxArea()
    val arr = arrayOf(1,8,6,2,5,4,8,3,7)
    val result = cma.maxArea(arr)
    println(result)
}