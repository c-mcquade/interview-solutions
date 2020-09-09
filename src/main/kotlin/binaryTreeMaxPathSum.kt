import kotlin.math.max

//

//Time complexity: O(N)\mathcal{O}(N)O(N), where N is number of nodes, since we visit each node not more than 2 times.

//Space complexity: O(H)\mathcal{O}(H)O(H), where HHH is a tree height, to keep the recursion stack. In the average case of balanced tree, the tree height H=log⁡NH = \log NH=logN, in the worst case of skewed tree, H=NH = NH=N.


class BinaryTreeMaxPathSum {

    private var maxSum = Int.MIN_VALUE

    private fun maxGain(node: TreeNode?): Int {
        if (node == null) return 0

        // max sum on the left and right sub-trees of node
        val leftGain = maxOf(maxGain(node.left), 0)
        val rightGain = maxOf(maxGain(node.right), 0)

        // the price to start a new path where `node` is a highest node
        val priceNewpath = node.`val` + leftGain + rightGain

        // update max_sum if it's better to start a new path
        maxSum = maxOf(maxSum, priceNewpath)

        // for recursion :
        // return the max gain if continue the same path
        return node.`val` + max(leftGain, rightGain)
    }

    fun maxPathSum(root: TreeNode?): Int {
        maxGain(root)
        return maxSum
    }
}