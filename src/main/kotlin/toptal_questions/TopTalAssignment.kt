package toptal_questions


class TopTalAssignment {

    fun solution(message: String, K: Int): String{
        if(K >= message.length)
            return message

        //edge case
        if(K == 0)
            return ""

        if(message[K - 1] == ' '){ // because indexes are 0 based, so we have to subtract 1.
            //means we landed outside a word
            return message.substring(0, K) // this assumes single space
        }
        else{
            //edge case
            if(K < message.length - 1 && message[K] == ' ')
                //this checks to see if K lands at a ' ', then just return it's K-1 index of characters since substring implies that implicitly
                //so if K = 6, and message = "hellohello", message.substring(0,K) will return "helloh" which is 0 to index - 1 ==> 0 - 5 index characters.
                return message.substring(0, K)

            var index = K - 1 // that is the max length of characters to be returned.
            var currentChar: Char = message[index]
            var prevChar: Char = message[index - 1]
            while(index > 0){
                prevChar = message[index - 1]
                currentChar = message[index]

                println("prev: ${prevChar}, curr: $currentChar")

                if(prevChar != ' ' && currentChar == ' ')
                    break

                index--
            }
            if(prevChar != ' ' && currentChar == ' '){
                return message.substring(0, index)
            }
        }
        return ""
    }

    fun solutionTwo(A: DoubleArray): Double{
        var totalPollution = 0.0
        A.forEach {
            totalPollution += it
        }
        val goalEmission: Double = totalPollution / 2.toDouble()
        // first sort the array
        A.sort()
        var rightPtr = A.size - 1 // start iterating from largest

        while(rightPtr >= 0){
            var halfItemAtRight = A[rightPtr] / 2.toDouble()
            //to get total, subtract itemAtIndex from overall total, then add the half of it, and update the array
            totalPollution -= A[rightPtr]
            totalPollution += halfItemAtRight
            A[rightPtr] = halfItemAtRight

            if(totalPollution <= goalEmission) { // return here if we have reached goal
                println("printing total below...")
                return totalPollution
            }

            if(rightPtr == 0){
                val prevRightWindow = A[rightPtr]
                halfItemAtRight = A[rightPtr] / 2.toDouble()
                A[rightPtr] = halfItemAtRight
                //set total pollution
                totalPollution -= prevRightWindow
                totalPollution += A[rightPtr]

                //Always check if we update totalPollution if we have reached goal
                if(totalPollution <= goalEmission) { // return here if we have reached goal
                    println("printing total below...")
                    return totalPollution
                }
            }else{
                while(A[rightPtr]  >= A[rightPtr - 1]){ // you want to cut the most chunk out first

                    val prevRightWindow = A[rightPtr]

                    println("halfItemAtRight: $halfItemAtRight, halfItemAtLeft: ${A[rightPtr - 1] / 2.toDouble()}, " +
                            "totalPollution: $totalPollution, goal: $goalEmission | prevRightWindow: $prevRightWindow")

                    halfItemAtRight = A[rightPtr] / 2.toDouble()
                    A[rightPtr] = halfItemAtRight
                    //set total pollution
                    totalPollution -= prevRightWindow
                    totalPollution += halfItemAtRight

                    if(totalPollution <= goalEmission) { // return here if we have reached goal
                        println("printing total below...")
                        return totalPollution
                    }
                }
            }
            rightPtr--
        }
        return totalPollution
    }
}

fun testTopTalAssignment(){
    val ta = TopTalAssignment()
    println(ta.solution("Codility We test coders", 14))

    println(ta.solution("To crop or not to crop", 21))

    println(ta.solution("The quick brown fox jumps over the lazy dog", 39))

    println(ta.solution("a", 0))

    //println("The quick brown fox jumps over the lazy".length)
    println()
    println("=========SHIFTING GEARS TO Emission Problem===============")
    println()

    println(ta.solutionTwo(doubleArrayOf(5.0, 19.0, 8.0, 1.0)))  //1,5,8,19

    println(ta.solutionTwo(doubleArrayOf(10.0, 10.0)))

    println(ta.solutionTwo(doubleArrayOf(4.0, 4.0, 2.0, 1.0, 6.0)))

    println(ta.solutionTwo(doubleArrayOf(1.0, 1.0, 1.0, 1.0, 1.0, 1.0)))

    // val a = 10.toDouble()/4.toDouble()
    // println(a)
    println("hellohello".substring(0, 6))
}

