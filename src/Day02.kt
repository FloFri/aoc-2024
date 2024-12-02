import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Int {
        var result = 0
        for (line in input) {
            val splitLine = line.split(" ").filter { it.isNotBlank() }.map { it.toInt() }

            val direction = splitLine[1] - splitLine[0]
            var safe = true

            for (i in 0..<splitLine.size-1) {
                val difference : Int = splitLine[i+1] - splitLine[i]

                if (abs(difference) > 3 || difference == 0) {
                    safe = false
                    break
                }

                if ((difference > 0 && direction < 0) || (difference < 0 && direction > 0)) {
                    safe = false
                    break
                }
            }

            if (safe) {
                result += 1
            }
        }

        return result
    }

    fun part2(input: List<String>): Int {
        var result = 0
        for (line in input) {
            val splitLine = line.split(" ").filter { it.isNotBlank() }.map { it.toInt() }

            var direction = splitLine[1] - splitLine[0]
            var safe = true

            for (i in 0..<splitLine.size - 1) {
                val difference: Int = splitLine[i + 1] - splitLine[i]

                if (abs(difference) > 3 || difference == 0) {
                    safe = false
                    break
                }

                if ((difference > 0 && direction < 0) || (difference < 0 && direction > 0)) {
                    safe = false
                    break
                }
            }

            if (safe) {
                result += 1
            } else {
                // Try again with removed elements
                for (i in splitLine.indices) {
                    val tmpLine = splitLine.toMutableList()
                    tmpLine.removeAt(i)

                    direction = tmpLine[1] - tmpLine[0]
                    safe = true
                    for (j in 0..<tmpLine.size - 1) {
                        val difference: Int = tmpLine[j + 1] - tmpLine[j]

                        if (abs(difference) > 3 || difference == 0) {
                            safe = false
                            break
                        }

                        if ((difference > 0 && direction < 0) || (difference < 0 && direction > 0)) {
                            safe = false
                            break
                        }
                    }

                    if (safe) {
                        result += 1
                        break
                    }
                }
            }
        }

        return result
    }

    // Test if implementation meets criteria from the description, like:
    //check(part1(listOf("test_input")) == 1)

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 2)
    check(part2(testInput) == 6)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day02")
    part1(input).println()
    part2(input).println()
}
