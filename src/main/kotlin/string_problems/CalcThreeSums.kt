package string_problems

import java.util.*

//arr = intArrayOf(-3, 0, 1, 2, -1, 1, -2)
//[-3, 1, 2]
//[-2, 0, 2]
//[-2, 1, 1]
//[-1, 0, 1]
class CalcThreeSums {
    fun threeSum(nums: IntArray): List<List<Int>> {
        Arrays.sort(nums)
        val result: ArrayList<List<Int>> = ArrayList()
        var i = 0

        while(i < nums.size && nums[i] <= 0){
            if(i == 0 || nums[i-1] != nums[i]) { //the first half ensure that first element is executed, the second part is the real condition.
                twoSumII(nums, i, result)
            }
            i++
        }
        return result.toList()
    }

    private fun twoSumII(nums: IntArray, i: Int, result: ArrayList<List<Int>>) {
        var low = i + 1
        var hi = nums.size - 1
        while( low < hi ){
            val sum = nums[i] + nums[low] + nums[hi]
            if(sum < 0){ // means we need more positive numbers
                low++
            }else if(sum > 0){ // means we need less positive numbers
                hi--
            }else{ // sum equals zero, so we add to result list
                result.add(listOf(nums[i], nums[low++], nums[hi--])) //also ensure that we don't get duplicates
                while(low < hi && nums[low] == nums[low - 1]) // this ensures we don't get duplicates in our result
                    low++
            }
        }
    }
}

fun testThreeSums() {
    val cts = CalcThreeSums()
    var arr = intArrayOf(-1,0,1,2,-1,-4)
    //val arr = arrayOf(1, 2, -2, -1)
    //val arr = arrayOf(3, 0, -2, -1, 1, 2)
    var result: List<List<Int>> = cts.threeSum(arr)

    for(list in result){
        print("[")
        for((index, innerList) in list.withIndex()){
            print("$innerList")
            if(index < list.size - 1)
                print(", ")
        }
        print("]")
        println()
    }
    println("---------------------------")

    arr = intArrayOf(-3, 0, 1, 2, -1, 1, -2)
    result = cts.threeSum(arr)

    for(list in result){
        print("[")
        for((index, innerList) in list.withIndex()){
            print("$innerList")
            if(index < list.size - 1)
                print(", ")
        }
        print("]")
        println()
    }
    println("---------------------------")
}