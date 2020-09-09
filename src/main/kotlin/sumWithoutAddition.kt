import kotlin.math.abs

fun getSum(a: Int, b: Int): Int {
    var x = abs(a)
    var y = abs(b)
    // ensure that abs(a) >= abs(b)
    if (x < y) return getSum(b, a)

    // abs(a) >= abs(b) -->
    // a determines the sign
    val sign = if (a > 0) 1 else -1
    if (a * b >= 0) {
        // sum of two positive integers x + y
        // where x > y
        while (y != 0) {
            val answer = x xor y
            val carry = x and y shl 1
            x = answer
            y = carry
        }
    } else {
        // difference of two positive integers x - y
        // where x > y
        while (y != 0) {
            val answer = x xor y
            val borrow = x.inv() and y shl 1
            x = answer
            y = borrow
        }
    }
    return x * sign
}

fun main() {

    println(getSum(10, 11))

}