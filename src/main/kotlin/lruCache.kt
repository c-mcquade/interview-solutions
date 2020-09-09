
import java.util.*

internal class LRUCache(private val capacity: Int) : LinkedHashMap<Int?, Int?>(capacity, 0.75f, true) {
    operator fun get(key: Int): Int {
        return super.getOrDefault(key, -1)!!
    }

    fun put(key: Int, value: Int) {
        super.put(key, value)
    }

    override fun removeEldestEntry(eldest: Map.Entry<Int?, Int?>): Boolean {
        return size > capacity
    }
}