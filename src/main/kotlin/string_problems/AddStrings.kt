package string_problems


class AddStrings {

    fun addTwoStrings(num1: String, num2: String): String{
        val res = StringBuilder()

        var carry = 0
        var p1 = num1.length - 1
        var p2 = num2.length - 1

        while(p1 >= 0 || p2 >= 0){
            val x1 = if(p1 >= 0) num1[p1].code else 0

            if(p1 >= 0)
                println("**** ${num1[p1]}: ${num1[p1].code}")
            val x2 = if(p2 >= 0) num2[p2].code else 0

            if(p2 >= 0)
                println("**** ${num2[p2]}: ${num2[p2].code}")
            val sum = (x1 + x2 + carry) % 10
            carry = (x1 + x2 + carry)/10

            println("sum: $sum, carry: $carry")

            res.append(sum)
            p1--
            p2--
        }

        if(carry != 0){
            res.append(carry)
        }
        return res.reverse().toString()
    }
}

fun testAddTwoStrings(){
    val num1 = "11"
    val num2 = "123"
    val addStr = AddStrings()

    val result = addStr.addTwoStrings(num1, num2)
    println(result)

}