fun validPalindrome(s: String): Boolean {
    var l = -1
    var r = s.length
    while (++l <= --r) {
        if (s[l] != s[r]) {
            return (isPalindrome(s, l + 1, r)
                    || isPalindrome(s, l, r - 1))
        }
    }
    return true
}

fun isPalindrome(s: String, from: Int, to: Int): Boolean {
    var from = from
    var to = to
    while (from <= to) {
        if (s[from] != s[to]) return false
        from++
        to--
    }
    return true
}