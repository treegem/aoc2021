package day06

import readTxtFileAsString
import util.toDayIndex

val dayIndex = 6.toDayIndex()

fun main() {
    val input = readTxtFileAsString("day$dayIndex/Day$dayIndex")
    println(part1(input))
    println(part2(input))
}

fun part1(input: String): Long {
    val timers = convertToTimers(input)
    passDays(80, timers)
    return timers.values.sum()
}

fun part2(input: String): Long {
    val timers = convertToTimers(input)
    passDays(256, timers)
    return timers.values.sum()
}
