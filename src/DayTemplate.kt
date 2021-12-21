import util.toDayIndex

val dayIndex = 1.toDayIndex()

fun main() {
    val input = readTxtFileAsLines("day$dayIndex/Day$dayIndex")
    println(part1(input))
    println(part2(input))
}

fun part1(input: List<String>): Int {
    return input.size
}

fun part2(input: List<String>): Int {
    return input.size
}
