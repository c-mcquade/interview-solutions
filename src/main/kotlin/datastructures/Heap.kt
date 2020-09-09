package datastructures

class Heap private constructor(
    size: Int,
    seed: Int,
    val compare: (Int, Int) -> Boolean
){

    private var heapSize = 0
    private val array = IntArray(size + 1).also { it[0] = seed }

    companion object {
        private const val FRONT = 1
        private const val EMPTY_HEAP_ERROR = "heap is empty"
        private const val MAX_SIZE_ERROR = "at max size"

        fun minHeap(size: Int = 10): Heap = Heap(size, Int.MIN_VALUE) { a, b -> a < b }
        fun maxHeap(size: Int = 10): Heap = Heap(size, Int.MAX_VALUE) { a, b -> a > b }

        private fun parent(i: Int) = i shr 1
        private fun left(i: Int) = i shl 1
        private fun right(i: Int) = left(i) + 1
    }

    fun size() = heapSize

    fun pop(): Int {
        require(heapSize > 0) { error("Heap is empty") }

        val popped = peek()
        array[FRONT] = array[heapSize--]
        heapify(FRONT)
        return popped
    }

    private fun swap(i: Int, j: Int) {
        array[i] = array[j].also { array[j] = array[i] }
    }

    private tailrec fun heapify(i: Int) {
        val left = left(i)
        val right = right(i)

        var ordered = when {
            left <= heapSize && compare(array[i], array[left]) -> i
            left <= heapSize -> left
            else -> i
        }

        if(right <= heapSize && !compare(array[ordered], array[right]))
            ordered = right

        if(ordered != i) {
            swap(ordered, i)
            heapify(ordered)
        }
    }

    fun peek() = if(heapSize > 0) array[1] else error(EMPTY_HEAP_ERROR)

}
