
import java.util.*


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class BSTIterator(root: TreeNode?) {
    private val stack: Stack<TreeNode> = Stack()
    private fun _leftmostInorder(root: TreeNode?) {

        // For a given node, add all the elements in the leftmost branch of the tree
        // under it to the stack.
        var root = root
        while (root != null) {
            stack.push(root)
            root = root.left
        }
    }

    /**
     * @return the next smallest number
     */
    operator fun next(): Int {
        // Node at the top of the stack is the next smallest element
        val topmostNode = stack.pop()

        // Need to maintain the invariant. If the node has a right child, call the
        // helper function for the right child
        if (topmostNode.right != null) {
            _leftmostInorder(topmostNode.right)
        }
        return topmostNode.`val`
    }

    /**
     * @return whether we have a next smallest number
     */
    operator fun hasNext(): Boolean {
        return stack.size > 0
    }

    init {

        // Stack for the recursion simulation

        // Remember that the algorithm starts with a call to the helper function
        // with the root node as the input
        _leftmostInorder(root)
    }
}