import kotlin.math.max
import kotlin.math.min

fun findMedianSortedArrays(a: IntArray, b: IntArray): Double {

    val (smallArray, largeArray) = if (a.size > b.size) b to a else a to b
    val (smallLength, largeLength) = if (a.size > b.size) b.size to a.size else a.size to b.size

    var minIndex = 0
    var maxIndex = smallLength
    val halfLength = (smallLength + largeLength + 1) / 2

    while(minIndex <= maxIndex) {
        val takeFromSmall = (minIndex + maxIndex) / 2
        val takeFromLarge = halfLength - takeFromSmall

        when {
            takeFromSmall < maxIndex && largeArray[takeFromLarge] > smallArray[takeFromSmall] -> {
                minIndex = takeFromSmall + 1
            }
            takeFromSmall > minIndex && smallArray[takeFromSmall - 1] > largeArray[takeFromLarge] -> {
                maxIndex = takeFromSmall - 1
            }
            else -> {

                val maxLeft = when {
                    takeFromSmall == 0 -> largeArray[takeFromLarge - 1]
                    takeFromLarge == 0 -> smallArray[takeFromSmall - 1]
                    else -> maxOf(smallArray[takeFromSmall - 1], largeArray[takeFromLarge - 1])
                }
                if((smallLength + largeLength) % 2 == 1) return maxLeft.toDouble()

                val minRight = when {
                    takeFromSmall == smallLength -> largeArray[takeFromLarge]
                    takeFromLarge == largeLength -> smallArray[takeFromSmall]
                    else -> minOf(largeArray[takeFromLarge], smallArray[takeFromSmall])
                }

                return (minRight + maxLeft) / 2.0
            }
        }
    }

    return 0.0
}


fun main() {
    println(findMedianSortedArrays(intArrayOf(1, 2, 3), intArrayOf(5, 7, 9, 34, 56)))
}

