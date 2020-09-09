package datastructures

import kotlin.jvm.internal.Ref

interface Graph<T> {
    fun createVertex(data: T): Vertex<T>

    fun addDirectedEdge(
        source: Vertex<T>,
        destination: Vertex<T>,
        weight: Double?
    )

    fun addUndirectedEdge(
        source: Vertex<T>,
        destination: Vertex<T>,
        weight: Double?
    )

    fun add(
        edge: EdgeType,
        source: Vertex<T>,
        destination: Vertex<T>,
        weight: Double?
    )

    fun edges(source: Vertex<T>): List<Edge<T>>

    fun weight(source: Vertex<T>, destination: Vertex<T>): Double?
}

enum class EdgeType {
    DIRECTED, UNDIRECTED
}

data class Vertex<T>(val index: Int, val data: T)

data class Edge<T>(
    val source: Vertex<T>,
    val destination: Vertex<T>,
    val weight: Double? = null
)

class AdjacencyList<T>: Graph<T> {
    private val adjacencies: HashMap<Vertex<T>, MutableList<Edge<T>>> = hashMapOf()

    override fun createVertex(data: T): Vertex<T> {
        val vertex = Vertex(adjacencies.count(), data)
        adjacencies[vertex] = mutableListOf()
        return vertex
    }

    override fun addDirectedEdge(source: Vertex<T>, destination: Vertex<T>, weight: Double?) {
        val edge = Edge(source, destination, weight)
        adjacencies[source]?.add(edge)
    }

    override fun addUndirectedEdge(source: Vertex<T>, destination: Vertex<T>, weight: Double?) {
        addDirectedEdge(source, destination, weight)
        addDirectedEdge(destination, source, weight)
    }

    override fun edges(source: Vertex<T>): List<Edge<T>> =
        adjacencies[source]?.toList() ?: emptyList()


    override fun weight(source: Vertex<T>, destination: Vertex<T>): Double? =
        edges(source).firstOrNull { it.destination == destination }?.weight


    override fun add(edge: EdgeType, source: Vertex<T>, destination: Vertex<T>, weight: Double?) {
        when(edge) {
            EdgeType.DIRECTED -> addDirectedEdge(source, destination, weight)
            EdgeType.UNDIRECTED -> addUndirectedEdge(source, destination, weight)
        }
    }

    fun numberOfPaths(source: Vertex<T>, destination: Vertex<T>): Int {
        val numberOfPaths = Ref(0)
        val visited: MutableSet<Vertex<T>> = mutableSetOf()
        paths(source, destination, visited, numberOfPaths)
        return numberOfPaths.value
    }

    fun depthFirstSearchRecursive(start: Vertex<T>):
            ArrayList<Vertex<T>> {
        val visited = arrayListOf<Vertex<T>>() // 1
        val pushed = mutableSetOf<Vertex<T>>() // 2
        depthFirstSearch(start, visited, pushed) // 3
        return visited
    }

    fun depthFirstSearch(
        source: Vertex<T>,
        visited: ArrayList<Vertex<T>>,
        pushed: MutableSet<Vertex<T>>
    ) {
        pushed.add(source) // 1 visited.add(source)
        val neighbors = edges(source)
        neighbors.forEach { // 2
            if (it.destination !in pushed) {
                depthFirstSearch(it.destination, visited, pushed) // 3
            }
        }
    }

    fun paths(source: Vertex<T>, destination: Vertex<T>, visited: MutableSet<Vertex<T>>, pathCount: Ref<Int>) {

        visited.add(source)
        if(source == destination) {
            pathCount.value += 1
        } else {
            val neighbours = edges(source)
            neighbours.forEach {
                if(it.destination !in visited) {
                    paths(it.destination, destination, visited, pathCount)
                }
            }
        }
         visited.remove(source)
    }

    data class Ref<T>(var value: T)

    override fun toString(): String {
        return buildString {
            adjacencies.forEach { vertex, edges ->
                val edgeString = edges.joinToString { it.destination.data.toString() }
                append("$vertex ---> [ $edgeString ] \n")
            }
        }
    }
}



fun main() {

    val graph = AdjacencyList<String>()

    val singapore = graph.createVertex("Singapore")
    val tokyo = graph.createVertex("Tokyo")
    val hongKong = graph.createVertex("Hong Kong")
    val detroit = graph.createVertex("Detroit")
    val sanFrancisco = graph.createVertex("San Francisco")
    val washingtonDC = graph.createVertex("Washington DC")
    val austinTexas = graph.createVertex("Austin Texas")
    val seattle = graph.createVertex("Seattle")

    graph.addUndirectedEdge(singapore, hongKong, 300.0)
    graph.add(EdgeType.UNDIRECTED, singapore, tokyo, 500.0)
    graph.add(EdgeType.UNDIRECTED, hongKong, tokyo, 250.0)
    graph.add(EdgeType.UNDIRECTED, tokyo, detroit, 450.0)
    graph.add(EdgeType.UNDIRECTED, tokyo, washingtonDC, 300.0)
    graph.add(EdgeType.UNDIRECTED, hongKong, sanFrancisco, 600.0)
    graph.add(EdgeType.UNDIRECTED, detroit, austinTexas, 50.0)
    graph.add(EdgeType.UNDIRECTED, austinTexas, washingtonDC, 292.0)
    graph.add(EdgeType.UNDIRECTED, sanFrancisco, washingtonDC, 337.0)
    graph.add(EdgeType.UNDIRECTED, washingtonDC, seattle, 277.0)
    graph.add(EdgeType.UNDIRECTED, sanFrancisco, seattle, 218.0)
    graph.add(EdgeType.UNDIRECTED, austinTexas, sanFrancisco, 297.0)



    println(graph.numberOfPaths(detroit, washingtonDC))

}
