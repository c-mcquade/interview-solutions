package datastructures

class Queue<T>: Collection<T> {
    private var head: Node<T>? = null
    private var tail: Node<T>? = null

    override var size: Int = 0
        private set

    private class Node<T>(var value: T) {
        var next: Node<T>? = null
    }

    fun add(item: T) {
        val new = Node(item)
        val tail = this.tail

        if(tail == null) {
            head = new
            this.tail = new
        } else {
            tail.next = new
            this.tail = new
        }

        size ++
    }

    fun peek(): T {
        if(size == 0) throw NoSuchElementException()
        return head!!.value
    }

    fun poll(): T {
        if(size == 0) throw NoSuchElementException()
        val old = head!!
        head = old.next
        size--
        return old.value
    }

    override fun contains(element: T): Boolean =
        this.any { element == it }


    override fun containsAll(elements: Collection<T>): Boolean =
        elements.all { contains(it) }


    override fun isEmpty(): Boolean = size == 0

    override fun iterator(): Iterator<T> {
        return object : Iterator<T> {
            var node = head

            override fun hasNext(): Boolean {
                return node != null
            }

            override fun next(): T {
                if(!hasNext()) throw NoSuchElementException()
                val old = node
                node = old!!.next
                return old.value
            }
        }
    }
}
