import kotlin.math.max

fun leastInterval(tasks: CharArray, n: Int): Int {
    // frequencies of the tasks
    val frequencies = IntArray(26)
    for (t in tasks) {
        frequencies[t.toInt() - 'A'.toInt()]++
    }

    // max frequency
    var fMax = 0
    for (f in frequencies) {
        fMax = max(fMax, f)
    }

    // count the most frequent tasks
    var nMax = 0
    for (f in frequencies) {
        if (f == fMax) nMax++
    }
    return max(tasks.size, (fMax - 1) * (n + 1) + nMax)
}

//

//The maximum number of tasks is 26. Let's allocate an array frequencies of 26 elements to keep the frequency of each task.
//
//Iterate over the input array and store the frequency of task A at index 0, the frequency of task B at index 1, etc.
//
//Find the maximum frequency: f_max = max(frequencies).
//
//Find the number of tasks which have the max frequency: n_max = frequencies.count(f_max).
//
//If the number of slots to use is defined by the most frequent task, it's equal to (f_max - 1) * (n + 1) + n_max.
//
//Otherwise, the number of slots to use is defined by the overall number of tasks: len(tasks).
//
//Return the maximum of these two: max(len(tasks), (f_max - 1) * (n + 1) + n_max).
