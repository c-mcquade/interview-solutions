import java.util.*


fun minRemoveToMakeValid(s: String): String? {
    val indexesToRemove: MutableSet<Int> = HashSet()
    val stack = Stack<Int>()
    for (i in s.indices) {
        if (s[i] == '(') {
            stack.push(i)
        }
        if (s[i] == ')') {
            if (stack.isEmpty()) {
                indexesToRemove.add(i)
            } else {
                stack.pop()
            }
        }
    }
    // Put any indexes remaining on stack into the set.
    while (!stack.isEmpty()) indexesToRemove.add(stack.pop())
    val sb = StringBuilder()
    for (i in s.indices) {
        if (!indexesToRemove.contains(i)) {
            sb.append(s[i])
        }
    }
    return sb.toString()
}