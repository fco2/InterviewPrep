package geeksforgeeks


class TripletsWithZeroSum {

    fun findTriplets(arr: Array<Int>){
        var found = false

        for(i in arr.indices){ //0 until arr.size
            val tripletSet = mutableSetOf<Int>()
            for(j in i+1 until arr.size){
                val twoSumComplement = -(arr[i] + arr[j])
                if(tripletSet.contains(twoSumComplement)){ // means we found a match
                    println("Found $twoSumComplement, ${arr[i]}, ${arr[j]}")
                    found = true
                }
                else{
                    tripletSet.add(arr[j])
                }
            }

            if(!found)
                println("Didn't find triplet")
        }
    }

    fun find3Numbers(arr: Array<Int>, sum: Int){
        var found = false

        for(i in arr.indices){
            val tripletSet = mutableSetOf<Int>()
            for(j in i+1 until arr.size){
                val twoSumComplement = sum - (arr[i] + arr[j])
                if(tripletSet.contains(twoSumComplement)){
                    println("Found $twoSumComplement, ${arr[i]}, ${arr[j]}")
                    found = true
                }
                else{
                    tripletSet.add(arr[j])
                }
            }
        }
        if(!found)
            println("Didn't find triplet")
    }
}

fun testFindTriplets(){
    val arr = arrayOf(0, -1, 2, -3, 1)
    val twzs = TripletsWithZeroSum()
    twzs.findTriplets(arr)
}

fun testFind3Numbers(){
    val tn = TripletsWithZeroSum()
    var arr = arrayOf(12, 3, 4, 1, 6, 9)
    tn.find3Numbers(arr, 24)

    arr = arrayOf(1, 2, 3, 4, 5)
    tn.find3Numbers(arr, 9)
}