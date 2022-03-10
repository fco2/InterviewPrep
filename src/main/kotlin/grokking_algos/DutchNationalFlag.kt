package grokking_algos

class DutchNationalFlag {

    fun solution(arr: IntArray){
        var left = 0
        var right = arr.size - 1
        var index = 0

        //only have 0, 1, 2 in array
        while(index <= right){
            val curr = arr[index]

            if(curr == 0){
                swap(arr, index, left)
                //increment left and index
                left++
                index++
            }
            else if(curr == 2){
                swap(arr, index, right)
                //decrement right only and leave index alone
                right--
            }else{ //means curr == 1, so just move index
                index++
            }
        }

        arr.forEachIndexed() { i, it ->
            print(it)
            if(i < arr.size)
                print(", ")
        }
        println()
    }

    private fun swap(arr: IntArray, fromIndex: Int, toIndex: Int){
        val temp = arr[fromIndex]
        arr[fromIndex] = arr[toIndex]
        arr[toIndex] = temp
    }
}

fun testDutchNationalFlag(){
    val dnf = DutchNationalFlag()
    var arr = intArrayOf(1,0,2,1,0)
    println(dnf.solution(arr))

    arr = intArrayOf(2,2,0,1,2,0)
    println(dnf.solution(arr))
}