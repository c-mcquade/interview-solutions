fun hasPathSum(root: TreeNode?, sum: Int): Boolean {
    var sum = sum
    if (root == null) return false
    sum -= root.`val`
    return if (root.left == null && root.right == null) sum == 0 else hasPathSum(
        root.left,
        sum
    ) || hasPathSum(root.right, sum)
}