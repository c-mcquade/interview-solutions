import java.util.*
import kotlin.NoSuchElementException
import kotlin.collections.ArrayDeque
import kotlin.collections.HashSet


class Graph {
    private val nodeLookup = hashMapOf<Int, Node>()

    fun getNode(id: Int): Node {
        if(!nodeLookup.containsKey(id)) throw NoSuchElementException()
        return nodeLookup[id]!!
    }

    fun addEdge(source: Int, destination: Int) {
        val sourceNode = getNode(source)
        val destinationNode = getNode(destination)

        if(!sourceNode.adjacent.contains(destinationNode)) sourceNode.adjacent.add(destinationNode)
        if(!destinationNode.adjacent.contains(sourceNode)) destinationNode.adjacent.add(sourceNode)
    }

    fun hasPathDFS(source: Int, destination: Int): Boolean {
        val sourceNode = getNode(source)
        val destinationNode = getNode(destination)

        val visited = HashSet<Int>()

        fun hasPathDFS(sourceNode: Node, destinationNode: Node): Boolean {
            if(!visited.add(sourceNode.id)) return false
            if(sourceNode == destinationNode) return true
            sourceNode.adjacent.forEach {
                if(hasPathDFS(it, destinationNode)) return true
            }

            return false
        }


        return hasPathDFS(sourceNode, destinationNode)
    }

    private fun hasPathBFS(sourceNode: Node, destinationNode: Node): Boolean {
        val nextToVisit = ArrayDeque<Node>()
        val visited = HashSet<Int>()

        nextToVisit.add(sourceNode)
        while (!nextToVisit.isEmpty()) {
            val node = nextToVisit.removeLast()
            if(node == destinationNode) return true

            if (visited.contains(node.id)) continue
            visited.add(node.id)

            nextToVisit.addAll(node.adjacent)
        }

        return false
    }

    data class Node(
        val id: Int,
        val adjacent: HashSet<Node> = HashSet()
    )
}

fun main() {

}

