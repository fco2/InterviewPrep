package geeksforgeeks

import java.util.*


class MaximumEvents {

    internal class Pair(var startTime: Int, var endTime: Int)

    fun solution(start: IntArray, end: IntArray, N: Int): Int {
        val arr = arrayListOf<Pair>()
        for (i in 0 until N) {
            arr.add(Pair(start[i], end[i]))
        }

        //sort based on start date
        arr.sortWith(compareBy({ it.endTime }, {it.startTime}))

        /*println()
                println()*/

        val pq = PriorityQueue<Int>()

        var index = 0
        var result = 0
        var d = 0

        while(pq.isNotEmpty() || index < N ){
            if(pq.isEmpty()) {
                //TODO
                println("pq was empty at start: putting.. ${arr[index].startTime}")
                println()
                d = arr[index].startTime  // * Ref point 1
            }

            while(index < N && arr[index].startTime <= d){
                pq.offer(arr[index++].endTime) // add the endTime and increase index
            }
            //TODO
            printPriorityQueue(pq)
            println()

            pq.poll() // this removes the startTime from the queue added at (Ref point 1)
            result++ //increase result by 1
            d++ // increase the value of d by 1

            while(pq.isNotEmpty() && pq.peek() < d){
                pq.poll()
            }
        }
        return result
    }

    private fun printPriorityQueue(pq: PriorityQueue<Int>){
        pq.forEach {
            print("item -> $it")
        }
        println()
        println("-----------------")
    }
}

fun testMaximumEvents(){
    /*val start = intArrayOf(1,2,1)
    val end = intArrayOf(1,2,2)*/

    val start = intArrayOf(1,2,3)
    val end = intArrayOf(2,3,4)

    val me = MaximumEvents()

    val result = me.solution(start, end, 3)
    println(result)
}

// https://practice.geeksforgeeks.org/problems/ea8230731ccb057120bafb351c10c48b2d496125/1/?page=1&status[]=unsolved&category[]=Arrays&category[]=Dynamic%20Programming&category[]=Greedy&category[]=Searching&category[]=Recursion&category[]=Linked%20List&category[]=two-pointer-algorithm&category[]=Map&category[]=sliding-window&category[]=Design-Pattern&category[]=Algorithms&category[]=Data%20Structures&category[]=palindrome&category[]=logical-thinking&category[]=pattern-printing&category[]=Practice-Problems&category[]=Pattern%20Searching&category[]=set&category[]=Tutorial-Problems&category[]=Shortest%20Path&category[]=Reverse&category[]=anagram&category[]=Character%20Encoding&category[]=Strings&sortBy=latest


/*

There are N events in Geek's city. You are given two arrays start[] and end[] denoting starting and ending day of the events respectively. Event i starts at start[i] and ends at end[i].
You can attend an event i at any day d between start[i] and end[i] (start[i] ≤ d ≤ end[i]). But you can attend only one event in a day.
Find the maximum number of events you can attend.



Example 1:

Input:
N = 3
start[] = {1, 2, 1}
end[] = {1, 2, 2}
Output:
2
Explanation:
You can attend a maximum of two events.
You can attend 2 events by attending 1st event
at Day 1 and 2nd event at Day 2.

Example 2:

Input:
N = 3
start[i] = {1, 2, 3}
end[i] = {2, 3, 4}
Output :
3
Explanation:
You can attend all events by attending event 1
at Day 1, event 2 at Day 2, and event 3 at Day 3.


 */