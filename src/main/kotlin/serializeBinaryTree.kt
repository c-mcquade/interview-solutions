/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Codec() {
    fun serialize(root: TreeNode?): String {
        return serializeNode(root)
    }

    private fun serializeNode(node: TreeNode?, str: String = ""): String {
        var newStr = str
        if(node == null) {
            newStr += "null,"
        } else {
            newStr += node.`val`.toString() + ","
            newStr = serializeNode(node.left, newStr)
            newStr = serializeNode(node.right, newStr)

        }


        return newStr
    }




    // Decodes your encoded data to tree.
    fun deserialize(data: String): TreeNode? {
        val split = data.split(",").map{ it.toIntOrNull() }.toMutableList()
        return deserializeNodes(split)
    }

    fun deserializeNodes(values: MutableList<Int?>): TreeNode? {
        if(values.isEmpty()) return null

        if(values.first() == null) {
            values.removeAt(0)
            return null
        }

        val node = TreeNode(values.first()!!)
        values.removeAt(0)
        node.left = deserializeNodes(values)
        node.right = deserializeNodes(values)

        return node
    }
}

 class TreeNode(var `val`: Int) {
     var left: TreeNode? = null
     var right: TreeNode? = null
 }