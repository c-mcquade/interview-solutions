import kotlin.math.max

class Kadane {

    fun maxSubArraySum(a: IntArray): Int {
        val size = a.size
        var maxSoFar = Int.MIN_VALUE
        var maxEndingHere = 0
        for (i in 0 until size) {
            maxEndingHere += a[i]
            if (maxSoFar < maxEndingHere) maxSoFar = maxEndingHere
            if (maxEndingHere < 0) maxEndingHere = 0
        }
        return maxSoFar
    }
}


//The problem to find maximum (or minimum) element (or sum) with a single array as the input is a good candidate to
// be solved by the greedy approach in linear time. One can find the examples of linear time greedy solutions in our articles of
//Super Washing Machines, and Gas Problem.
//
//    Pick the locally optimal move at each step, and that will lead to the globally optimal solution.
//
//The algorithm is general and straightforward: iterate over the array and update at each step the standard set for such problems:
//
//    current element
//
//    current local maximum sum (at this given point)
//
//    global maximum sum seen so far.

fun maxSubArray(nums: IntArray): Int {
    val n = nums.size
    var currSum = nums[0]
    var maxSum = nums[0]
    for (i in 1 until n) {
        currSum = max(nums[i], currSum + nums[i])
        maxSum = max(maxSum, currSum)
    }
    return maxSum
}


//@JvmStatic
//fun main(args: Array<String>) {
//    val a = intArrayOf(-2, -3, 4, -1, -2, 1, 5, -3)
//    println(
//        "Maximum contiguous sum is " +
//                maxSubArraySum(a)
//    )
//}
