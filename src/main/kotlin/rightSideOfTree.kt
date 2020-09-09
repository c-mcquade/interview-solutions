
import java.util.*


class RightSide {
    fun rightSideView(root: TreeNode?): List<Int> {
        val rightSide = mutableListOf<Int>()
        if(root == null) return rightSide

        fun dfsRight(root: TreeNode, level: Int) {
            if(level == rightSide.size) rightSide.add(root.`val`)

            if(root.right != null) dfsRight(root.right!!, level + 1)
            if(root.left != null) dfsRight(root.left!!, level + 1)
        }


        dfsRight(root, 0)
        return rightSide.toList()

    }

//    fun rightSideView2(root: TreeNode?): List<Int?>? {
//        if (root == null) return ArrayList()
//        val queue: ArrayDeque<TreeNode> = object : ArrayDeque() {
//            init {
//                offer(root)
//            }
//        }
//        val rightside: MutableList<Int?> = ArrayList<Any?>()
//        while (!queue.isEmpty()) {
//            val levelLength: Int = queue.size()
//            for (i in 0 until levelLength) {
//                val node: TreeNode = queue.poll()
//                // if it's the rightmost element
//                if (i == levelLength - 1) {
//                    rightside.add(node.`val`)
//                }
//
//                // add child nodes in the queue
//                if (node.left != null) {
//                    queue.offer(node.left)
//                }
//                if (node.right != null) {
//                    queue.offer(node.right)
//                }
//            }
//        }
//        return rightside
//    }
}