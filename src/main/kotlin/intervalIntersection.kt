
import java.util.*
import kotlin.math.max
import kotlin.math.min


fun intervalIntersection(A: Array<IntArray>, B: Array<IntArray>): Array<IntArray?>? {
    val ans: MutableList<IntArray?> = ArrayList()
    var i = 0
    var j = 0
    while (i < A.size && j < B.size) {
        // Let's check if A[i] intersects B[j].
        // lo - the startpoint of the intersection
        // hi - the endpoint of the intersection
        val lo = max(A[i][0], B[j][0])
        val hi = min(A[i][1], B[j][1])
        if (lo <= hi) ans.add(intArrayOf(lo, hi))

        // Remove the interval with the smallest endpoint
        if (A[i][1] < B[j][1]) i++ else j++
    }
    return ans.toTypedArray()
}

// Intuition
//
//In an interval [a, b], call b the "endpoint".
//
//Among the given intervals, consider the interval A[0] with the smallest endpoint.
// (Without loss of generality, this interval occurs in array A.)
//
//Then, among the intervals in array B, A[0] can only intersect one such interval in array B.
// (If two intervals in B intersect A[0], then they both share the endpoint of A[0] -- but intervals in B are disjoint, which is a contradiction.)
//
//Algorithm
//
//If A[0] has the smallest endpoint, it can only intersect B[0].
// After, we can discard A[0] since it cannot intersect anything else.
//
//Similarly, if B[0] has the smallest endpoint, it can only intersect A[0],
// and we can discard B[0] after since it cannot intersect anything else.
//
//We use two pointers, i and j, to virtually manage "discarding" A[0] or B[0] repeatedly.