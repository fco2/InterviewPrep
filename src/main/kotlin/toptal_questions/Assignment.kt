package toptal_questions


class Assignment {

    fun solution(A: IntArray): Int{
        val smallestInt: Int
        A.sort()

        //A.forEach { print("$it ->") }
        println()
        for(index in 1 until A.size){
            // 1, 2, 1, 1
            if(A[index - 1] == (A[index] - 1) || A[index - 1] == A[index]){
                continue
            }else{
                if(A[index - 1] > 0){
                    println("index: ${A[index]} indexMinus1: ${A[index - 1]}")
                    smallestInt = A[index - 1] + 1
                    return  smallestInt
                }
            }
        }
        val lastIndex = A[A.size - 1]
        return if(lastIndex < 1) 1 else A[A.size - 1] + 1
    }
}

fun testAssignment(){
    val a = Assignment()
    var A = intArrayOf(1, 3, 6, 4, 1, 2)  // 5
    println(a.solution(A))

    A = intArrayOf(1,2, 3)   //4
    println(a.solution(A))

    A = intArrayOf(-1, -3, -4)   //4
    println(a.solution(A))

    // [−1, −3], the function should return 1.
}