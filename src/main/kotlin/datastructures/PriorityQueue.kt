package datastructures

class PriorityQueue<T>(size: Int, val comparator: Comparator<T>? = null): Collection<T> {

    public override var size: Int = 0
        private set
    private var arr: Array<T?> = Array<Comparable<T>?>(size) {null} as Array<T?>

    fun add(element: T) {
        if(size + 1 == arr.size) {
//            resize()
        }
        arr[++size] = element
//        swim(size)
    }

    public fun peek(): T {
        if (size == 0) throw NoSuchElementException()
        return arr[1]!!
    }

    public fun poll(): T {
        if(size == 0) throw NoSuchElementException()
        val res = peek()
//        arr.exch
        TODO()
    }


    override fun contains(element: T): Boolean {
        TODO("Not yet implemented")
    }

    override fun containsAll(elements: Collection<T>): Boolean {
        TODO("Not yet implemented")
    }

    override fun isEmpty(): Boolean {
        TODO("Not yet implemented")
    }

    override fun iterator(): Iterator<T> {
        TODO("Not yet implemented")
    }


}