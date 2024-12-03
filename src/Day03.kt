fun main() {
    fun part1(input: List<String>): Int {
        val mulRegex = """mul\(([0-9]{1,3}),([0-9]{1,3})\)""".toRegex()

        val inputLine = input[0]
        val result = mulRegex.findAll(inputLine).map { it.groupValues[1].toInt()*it.groupValues[2].toInt() }.sum()
        return result
    }

    fun part2(input: List<String>): Int {
        val instructRegex = """do\(\)|don't\(\)|mul\(([0-9]{1,3}),([0-9]{1,3})\)""".toRegex()

        val matches = instructRegex.findAll(input[0])
        var result = 0
        var enabled = true

        for (match in matches) {
            when (match.groupValues[0]) {
                "do()" -> enabled = true
                "don't()" -> enabled = false
                else -> {
                    if (enabled) {
                        result += (match.groupValues[1].toInt() * match.groupValues[2].toInt())
                    }
                }
            }
        }
        return result
    }

    // Test if implementation meets criteria from the description, like:
    //check(part1(listOf("test_input")) == 1)

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day03_test")
    check(part1(testInput) == 161)
    check(part2(testInput) == 48)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day03")
    part1(input).println()
    part2(input).println()
}
