import java.util.*
import kotlin.math.min

// There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you.
// You receive a list of non-empty words from the dictionary, where words are sorted lexicographically by the rules of this new language.
// Derive the order of letters in this language.
//
//Example 1:
//
//Input:
//[
//  "wrt",
//  "wrf",
//  "er",
//  "ett",
//  "rftt"
//]
//
//Output: "wertf"

class AlienDictionary {
    private val reverseAdjList: MutableMap<Char, MutableList<Char>> = HashMap()
    private val seen: MutableMap<Char, Boolean> = HashMap()
    private val output = StringBuilder()
    fun alienOrder(words: Array<String>): String {

        // Step 0: Put all unique letters into reverseAdjList as keys.
        words.forEach { word ->
            word.forEach { character ->
                reverseAdjList.putIfAbsent(character, ArrayList())
            }
        }

        // Step 1: Find all edges and add reverse edges to reverseAdjList.
        for (i in 0 until words.size - 1) {
            val word1 = words[i]
            val word2 = words[i + 1]
            // Check that word2 is not a prefix of word1.
            if (word1.length > word2.length && word1.startsWith(word2)) {
                return ""
            }
            // Find the first non match and insert the corresponding relation.
            for (j in 0 until min(word1.length, word2.length)) {
                if (word1[j] != word2[j]) {
                    reverseAdjList[word2[j]]!!.add(word1[j])
                    break
                }
            }
        }

        // Step 2: DFS to build up the output list.
        for (character in reverseAdjList.keys) {
            val result = dfs(character)
            if (!result) return ""
        }
        return if (output.length < reverseAdjList.size) {
            ""
        } else output.toString()
    }

    // Return true iff no cycles detected.
    private fun dfs(character: Char): Boolean {
        if (seen.containsKey(character)) {
            return seen[character]!! // If this node was grey (false), a cycle was detected.
        }
        seen[character] = false
        for (next in reverseAdjList[character]!!) {
            val result = dfs(next)
            if (!result) return false
        }
        seen[character] = true
        output.append(character)
        return true
    }
}