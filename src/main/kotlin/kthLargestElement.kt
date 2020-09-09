import java.util.*

fun findKthLargest(nums: IntArray, k: Int): Int {
    // init heap 'the smallest element first'
    val heap: PriorityQueue<Int> = PriorityQueue<Int> { n1, n2 -> n1 - n2 }

    // keep k largest elements in the heap
    for (n in nums) {
        heap.add(n)
        if (heap.size > k) heap.poll()
    }

    // output
    return heap.poll()
}