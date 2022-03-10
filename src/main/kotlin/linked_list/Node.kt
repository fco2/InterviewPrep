package linked_list

data class Node<T> (
    var data: T,
    var next: Node<T>? = null
        ){

    override fun toString(): String {
        return if(this.next != null)
            "$data -> ${this.next}"
        else
            ("$data")
    }
}