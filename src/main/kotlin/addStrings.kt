//That's a good old classical algorithm, and there is no conversion from binary string to decimal and back here.
// Let's consider the numbers bit by bit starting from the lowest one and compute the carry this bit will add.
//
//Start from carry = 0. If number a has 1-bit in this lowest bit, add 1 to the carry.
// The same for number b: if number b has 1-bit in the lowest bit, add 1 to the carry. At this point the carry for the lowest bit could be equal to (00)2(00)_2(00)2​, (01)2(01)_2(01)2​, or (10)2(10)_2(10)2​.
//
//Now append the lowest bit of the carry to the answer, and move the highest bit of the carry to the next order bit.
//
//Repeat the same steps again, and again, till all bits in a and b are used up.
// If there is still nonzero carry to add, add it. Now reverse the answer string and the job is done.
fun addBinary(a: String, b: String): String? {
    val aLength = a.length
    val bLength = b.length
    if (aLength < bLength) return addBinary(b, a)

    val largest = maxOf(aLength, bLength)
    val sb = StringBuilder()
    var carry = 0

    var j = bLength - 1
    for (i in largest - 1 downTo 0) {
        if (a[i] == '1') ++carry
        if (j > -1 && b[j--] == '1') ++carry
        if (carry % 2 == 1) sb.append('1') else sb.append('0')
        carry /= 2
    }
    if (carry == 1) sb.append('1')
    sb.reverse()
    return sb.toString()
}

fun main() {
    println(addBinary("0111", "0001"))
}

//

//No addition? OK, bit manipulation then.

//How to start? There is an interview tip for bit manipulation problems: if you don't know how to start, start from computing XOR for your input data.
// Strangely, that helps to go out for quite a lot of problems, Single Number II, Single Number III, Maximum XOR of Two Numbers in an Array, Repeated DNA Sequences, Maximum Product of Word Lengths, etc.

//Here XOR is a key as well, because it's a sum of two binaries without taking carry into account.

//To find current carry is quite easy as well, it's AND of two input numbers, shifted one bit to the left.

//Now the problem is reduced: one has to find the sum of answer without carry and carry.
// It's the same problem - to sum two numbers, and hence one could solve it in a loop with the condition statement "while carry is not equal to zero".

// Algorithm
//
//    Convert a and b into integers x and y, x will be used to keep an answer, and y for the carry.
//
//    While carry is nonzero: y != 0:
//
//        Current answer without carry is XOR of x and y: answer = x^y.
//
//        Current carry is left-shifted AND of x and y: carry = (x & y) << 1.
//
//        Job is done, prepare the next loop: x = answer, y = carry.
//
//    Return x in the binary form.

fun addStrings(num1: String, num2: String): String? {
    val res = StringBuilder()
    var carry = 0
    var p1 = num1.length - 1
    var p2 = num2.length - 1
    while (p1 >= 0 || p2 >= 0) {
        val x1 = if (p1 >= 0) num1[p1] - '0' else 0
        val x2 = if (p2 >= 0) num2[p2] - '0' else 0
        val value = (x1 + x2 + carry) % 10
        carry = (x1 + x2 + carry) / 10
        res.append(value)
        p1--
        p2--
    }
    if (carry != 0) res.append(carry)
    return res.reverse().toString()
}

fun addStrings2(num1: String, num2: String): String {

    var index1 = num1.length - 1
    var index2 = num2.length - 1

    var carry = 0

    return buildString {
        while(index1 >= 0 || index2 >= 0) {

            val x1 = if(index1 >= 0) num1[index1] - '0' else 0
            val x2 = if(index2 >= 0) num2[index2] - '0' else 0
            val value = (x1 + x2 + carry) % 10
            carry = (x1 + x2 + carry) / 10
            append(value)
            index1--
            index2--
        }
        println(carry)
        if(carry != 0) append(carry)
        reverse()
    }
}



fun addToArrayForm(A: IntArray, K: Int): List<Int?>? {
    val size = A.size
    var cur = K
    val ans = mutableListOf<Int>()
    var i = size
    while (--i >= 0 || cur > 0) {
        if (i >= 0) cur += A[i]
        ans.add(cur % 10)
        cur /= 10
    }
    ans.reverse()
    return ans
}