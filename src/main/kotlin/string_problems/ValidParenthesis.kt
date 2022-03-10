package string_problems

import java.util.*

class ValidParenthesis (){

    fun isValid(s: String): Boolean{
        if (s.isEmpty())
            return true
        if (s.length % 2 != 0)
            return false

        val stack: Stack<Char> = Stack<Char>()

        // {, (, [, ], ) }
        for (currentChar in s) {
            if (currentChar == '}' || currentChar == ']' || currentChar == ')') {
                if (currentChar == '}' && stack.isNotEmpty() && stack.peek() != '{')
                    return false
                if (currentChar == ')' && stack.isNotEmpty() && stack.peek() != '(')
                    return false
                if (currentChar == ']' && stack.isNotEmpty() && stack.peek() != '[')
                    return false
                //if we get here, it means there was a match found
                if (stack.isEmpty())
                    return false
                stack.pop()
            } else {
                stack.push(currentChar)
            }
        }
        return stack.isEmpty()
    }
}

fun testIsValid(){
    val s = "(()[]{}}"
    val vp = ValidParenthesis()

    println(vp.isValid(s))
}