package linked_list


class LinkedList<T>(
) {
    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    private var size: Int = 0

    //three operations
    //push -> add to the front
    //append -> add at the end
    //insert -> add at a certain position

    private fun isEmpty(): Boolean = size == 0

    fun push(data: T): LinkedList<T> {
        head = Node(data = data, next = head)
        if(tail == null){
            tail = head
        }
        size++
        return this
    }

    fun append(data: T): LinkedList<T>{
        if(head == null){
            push(data)
            return this
        }else{
            tail?.next = Node(data)
            tail = tail?.next  // Only safe (?.) or non-null asserted (!!.) calls are allowed on a nullable receiver of type Node<T>?
        }
        size++
        return this
    }

    fun itemAt(index: Int): Node<T>?{
        var currIndex = 0
        var currNode = head

        while(currNode != null && currIndex < index){
            currNode = currNode.next
            currIndex++
        }
        return currNode
    }

    fun insert(value: T, afterNode: Node<T>): Node<T>?{
        if(tail == afterNode){
            append(value)
            return tail!!
        }
        val newNode = Node(value, afterNode.next)
        afterNode.next = newNode
        size++
        return newNode
    }

    override fun toString(): String {
        return if(isEmpty())
            "Empty linkedList"
        else
            head.toString()
    }
}

fun testLinkedList(){
    //20, 25, [12], 35, 40, 9
    val list = LinkedList<Int>()
    list.append(20).append(25).append(35).append(40).append(9)
    println(list)
    val afterNode: Node<Int> = list.itemAt(1)!!
    list.insert(12, afterNode)
    println(list)
}

fun testLinkedList2(){
    //1, 3, 5, 7, [9]
    val list = LinkedList<Int>()
    list.append(1).append(3).append(5).append(7)
    val afterNode = list.itemAt(3)!!
    list.insert(9, afterNode)
    println(list)
}

fun testLinkedList3(){
    val list = LinkedList<Int>()
    list.push(12).push(13).push(14)
    println(list)
    println("Second list **********")
    val secondList = LinkedList<String>()
    secondList.append("a").append("b").append("e")
    println(secondList)
}