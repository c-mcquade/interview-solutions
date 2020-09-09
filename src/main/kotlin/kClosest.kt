
import java.util.*


internal class KClosestPoint {
    fun kClosest(points: Array<IntArray>, K: Int): Array<IntArray> {
        val size = points.size
        val distances = IntArray(size)
        for (i in 0 until size) distances[i] = dist(points[i])
        Arrays.sort(distances)
        val distK = distances[K - 1]
        val ans = Array(K) { IntArray(2) }
        var t = 0
        for (i in 0 until size) if (dist(points[i]) <= distK) ans[t++] = points[i]
        return ans
    }

    fun dist(point: IntArray): Int {
        return point[0] * point[0] + point[1] * point[1]
    }
}

// USE HEAP AS MORE OPTIMIZED SOLUTION