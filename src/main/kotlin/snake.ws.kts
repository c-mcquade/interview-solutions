class DiameterOfBinaryTree {
    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.isEmpty()) return ""
        if (strs.size == 1) return strs.first()

        val shortest = strs.minBy { it.length }!!.length

        var commonIndex = 0

        for (i in 0 until shortest) {
            val char = strs[0][i]
            if (strs.any { it[i] != char }) {
                break
            }
            commonIndex++
        }

        return strs[0].take(commonIndex)
    }
}


val x = DiameterOfBinaryTree().longestCommonPrefix(arrayOf("aaa","aacbaaa"))

println(x)
