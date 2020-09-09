import java.util.*


private fun solve(nums: IntArray): IntArray? {
    val res = IntArray(nums.size)
    val map: MutableMap<Int, Int> = HashMap()
    for (i in nums.indices) {
        map[nums[i]] = i + 1
    }
    val visited: MutableSet<Int> = HashSet()
    for (k in map.keys) {
        if (!visited.contains(k)) {
            val round: MutableSet<Int> = HashSet()
            while (!visited.contains(k)) {
                round.add(k)
                visited.add(k)
//                k = map[k]!!
            }
            for (i in round) {
                res[i - 1] = round.size
            }
        }
    }
    return res
}