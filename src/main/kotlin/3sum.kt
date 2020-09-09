import java.util.*


internal class Solution {
    fun threeSum(nums: IntArray): List<List<Int>?> {
        val res: MutableSet<List<Int>?> = HashSet()
        val dups: MutableSet<Int> = HashSet()
        val seen: MutableMap<Int, Int> = HashMap()

        for (i in nums.indices) if (dups.add(nums[i])) {
            for (j in i + 1 until nums.size) {
                val complement = -nums[i] - nums[j]
                if (seen.containsKey(complement) && seen[complement] == i) {
                    val triplet = mutableListOf(nums[i], nums[j], complement)
                    triplet.sort()
                    res.add(triplet)
                }
                seen[nums[j]] = i
            }
        }
        return ArrayList(res)
    }
}