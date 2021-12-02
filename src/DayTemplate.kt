fun main() {
    val dayIndex = 1.toString().padStart(2, '0')

    fun part1(input: List<String>): Int {
        return input.size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readTxtFile("day$dayIndex/Day${dayIndex}_test")
    check(part1(testInput) == 1)

    val input = readTxtFile("day$dayIndex/Day$dayIndex")
    println(part1(input))
    println(part2(input))
}
