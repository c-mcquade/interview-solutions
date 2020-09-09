import kotlin.math.max

internal class DiameterOfBinaryTree {
    var ans = 0
    fun diameterOfBinaryTree(root: TreeNode?): Int {
        ans = 1
        depth(root)
        return ans - 1
    }

    fun depth(node: TreeNode?): Int {
        if (node == null) return 0
        val L = depth(node.left)
        val R = depth(node.right)
        ans = max(ans, L + R + 1)
        return max(L, R) + 1
    }
}