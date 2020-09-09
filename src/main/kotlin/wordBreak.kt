import java.util.*


fun wordBreak(s: String, wordDict: List<String?>?): Boolean {
    val wordDictSet: Set<String?> = HashSet<String?>(wordDict)
    val queue: Queue<Int> = LinkedList<Int>()
    val visited = IntArray(s.length)
    queue.add(0)
    while (!queue.isEmpty()) {
        val start: Int = queue.remove()
        if (visited[start] == 0) {
            for (end in start + 1..s.length) {
                if (wordDictSet.contains(s.substring(start, end))) {
                    queue.add(end)
                    if (end == s.length) {
                        return true
                    }
                }
            }
            visited[start] = 1
        }
    }
    return false
}