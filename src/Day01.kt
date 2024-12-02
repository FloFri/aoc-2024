import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Int {
        val left = mutableListOf<Int>()
        val right = mutableListOf<Int>()

        for (line in input) {
            val splitLine = line.split(" ").filter { it.isNotBlank() }
            left.add(splitLine[0].toInt())
            right.add(splitLine[1].toInt())
        }

        left.sort()
        right.sort()

        var result = 0
        for (i in 0..<left.size) {
            result += abs(left[i] - right[i])
        }

        return result
    }

    fun part2(input: List<String>): Int {
        val left = mutableListOf<Int>()
        val right = mutableListOf<Int>()

        for (line in input) {
            val splitLine = line.split(" ").filter { it.isNotBlank() }
            left.add(splitLine[0].toInt())
            right.add(splitLine[1].toInt())
        }

        left.sort()
        right.sort()

        var result = 0
        for (leftValue in left) {
            val simScore = leftValue * right.count { it == leftValue }
            result += simScore
        }

        return result
    }

    // Test if implementation meets criteria from the description, like:
    //check(part1(listOf("test_input")) == 1)

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 11)
    check(part2(testInput) == 31)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}
