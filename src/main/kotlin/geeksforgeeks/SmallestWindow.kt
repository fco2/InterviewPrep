package geeksforgeeks


import kotlin.math.max
import kotlin.math.min

class SmallestWindow {

    fun solution(s: String): Int {
        var smallestWindow = Int.MAX_VALUE
        val arrFoundIndices = arrayOf(-1, -1, -1)

        // '0' in ascii is 48.
        //val one = '2'.code - 48

        for(index in s.indices){
            arrFoundIndices[s[index].code - 48] = index // so for array "12110", for char at index 0 ==> '1'.code - 48 == 49 - 48 = 1 ==> arrFoundIndices[1] = 0

            if(arrFoundIndices[0] != -1 && arrFoundIndices[1] != -1 && arrFoundIndices[2] != -1){ //means we found a window
                val upperBound = max(max(arrFoundIndices[0], arrFoundIndices[1]), arrFoundIndices[2])
                val lowerBound = min(min(arrFoundIndices[0], arrFoundIndices[1]), arrFoundIndices[2])
                smallestWindow = min(smallestWindow, upperBound - lowerBound + 1)
            }
        }

        return if(smallestWindow == Int.MAX_VALUE) -1 else smallestWindow
    }
}

fun testSmallestWindow(){
    val s = "121210" //"01212"
    val sw = SmallestWindow()
    val result = sw.solution(s)
    println(result)
}