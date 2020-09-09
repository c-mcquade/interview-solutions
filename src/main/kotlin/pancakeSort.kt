internal object PancakeSort {
    /* Reverses arr[0..i] */
    fun flip(arr: IntArray, i: Int) {
        var i = i
        var temp: Int
        var start = 0
        while (start < i) {
            temp = arr[start]
            arr[start] = arr[i]
            arr[i] = temp
            start++
            i--
        }
    }

    // Returns index of the
    // maximum element in
    // arr[0..n-1]
    fun findMax(arr: IntArray, n: Int): Int {
        var mi: Int
        var i: Int
        mi = 0
        i = 0
        while (i < n) {
            if (arr[i] > arr[mi]) mi = i
            ++i
        }
        return mi
    }

    // The main function that
    // sorts given array using
    // flip operations
    fun pancakeSort(arr: IntArray, n: Int): Int {
        // Start from the complete 
        // array and one by one 
        // reduce current size by one 
        for (curr_size in n downTo 2) {
            // Find index of the 
            // maximum element in 
            // arr[0..curr_size-1] 
            val mi = findMax(arr, curr_size)

            // Move the maximum element 
            // to end of current array 
            // if it's not already at  
            // the end 
            if (mi != curr_size - 1) {
                // To move at the end, 
                // first move maximum 
                // number to beginning 
                flip(arr, mi)

                // Now move the maximum  
                // number to end by 
                // reversing current array 
                flip(arr, curr_size - 1)
            }
        }
        return 0
    }

    /* Utility function to print array arr[] */
    fun printArray(arr: IntArray, arr_size: Int) {
        for (i in 0 until arr_size) print(arr[i].toString() + " ")
        println("")
    }

    /* Driver function to check for above functions*/
    @JvmStatic
    fun main(args: Array<String>) {
        val arr = intArrayOf(23, 10, 20, 11, 12, 6, 7)
        val n = arr.size
        pancakeSort(arr, n)
        println("Sorted Array: ")
        printArray(arr, n)
    }
}