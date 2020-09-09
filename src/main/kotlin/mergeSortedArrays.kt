
fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
    // two get pointers for nums1 and nums2
    var p1 = m - 1
    var p2 = n - 1
    // set pointer for nums1
    var p = m + n - 1

    // while there are still elements to compare
    while (p1 >= 0 && p2 >= 0) // compare two elements from nums1 and nums2
    // and add the largest one in nums1
        nums1[p--] = if (nums1[p1] < nums2[p2]) nums2[p2--] else nums1[p1--]

    // add missing elements from nums2
    System.arraycopy(nums2, 0, nums1, 0, p2 + 1)
}