package day05

import readTxtFile
import util.toDayIndex

val dayIndex = 5.toDayIndex()

fun main() {
    val input = readTxtFile("day$dayIndex/Day$dayIndex")
    println(part1(input))
    println(part2(input))
}

fun part1(input: List<String>): Int {
    val lineDefinitions = convertToLineDefinitions(input)
    return input.size
}

fun part2(input: List<String>): Int {
    return input.size
}
