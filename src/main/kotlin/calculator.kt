import java.util.*


fun calculate(s: String?): Int {
    if (s == null ) return 0
    val len = s.length
    if(len == 0) return 0

    val stack = Stack<Int>()
    var num = 0
    var sign = '+'
    for (i in 0 until len) {
        when {
            Character.isDigit(s[i]) -> {
                num = num * 10 + s[i].toInt() - '0'.toInt()
            }
            !Character.isDigit(s[i]) && s[i] != ' ' || i == len - 1 -> {
                when (sign) {
                    '-' -> {
                        stack.push(-num)
                    }
                    '+' -> {
                        stack.push(num)
                    }
                    '*' -> {
                        stack.push(stack.pop() * num)
                    }
                    '/' -> {
                        stack.push(stack.pop() / num)
                    }
                }
                sign = s[i]
                num = 0
            }
        }
    }
    return stack.sum()
}


fun calculate2(s: String?): Int {
    if (s == null) {
        return 0
    }
    val q: Queue<Char> = LinkedList()
    for (c in s.toCharArray()) {
        q.offer(c)
    }
    q.offer('+')
    return cal(q)
}

private fun cal(q: Queue<Char>): Int {
    var sign = '+'
    var num = 0
    val stack = Stack<Int>()
    loop@ while (!q.isEmpty()) {
        val c = q.poll()
        if (c == ' ') {
            continue
        }
        when {
            Character.isDigit(c) -> {
                num = 10 * num + c.toInt() - '0'.toInt()
            }
            c == '(' -> {
                num = cal(q)
            }
            else -> {
                when (sign) {
                    '+' -> {
                        stack.push(num)
                    }
                    '-' -> {
                        stack.push(-num)
                    }
                    '*' -> {
                        stack.push(stack.pop() * num)
                    }
                    '/' -> {
                        stack.push(stack.pop() / num)
                    }
                }
                num = 0
                sign = c
                if (c == ')') {
                    break@loop
                }
            }
        }
    }
    var sum = 0
    while (!stack.isEmpty()) {
        sum += stack.pop()
    }
    return sum
}