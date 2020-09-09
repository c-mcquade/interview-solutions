
import java.util.*


class SubarraySum {
    fun subarraySum2(nums: IntArray, k: Int): Int {
        var count = 0
        for (start in nums.indices) {
            var sum = 0
            for (end in start until nums.size) {
                sum += nums[end]
                if (sum == k) count++
            }
        }
        return count
    }

    fun subarraySum(nums: IntArray, k: Int): Int {
        var sum = 0
        var count = 0

        val map = hashMapOf<Int, Int>()
        map[0] = 1

        for(i in nums.indices) {
            sum += nums[i]
            if(map.containsKey(sum - k)) {
                count += map[sum - k]!!
            }
            map[sum] = (map[sum] ?: 0) + 1
        }

        return count
    }
}

fun main() {
    val result = SubarraySum().subarraySum(intArrayOf(0, 0, 0, 0, 0, 0, 0, 0), 0)
    println(result)
}