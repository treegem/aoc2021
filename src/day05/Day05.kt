package day05

import readTxtFile
import util.toDayIndex

val dayIndex = 5.toDayIndex()

fun main() {
    val input = readTxtFile("day$dayIndex/Day$dayIndex")
    println(part1(input))
    println(part2(input))
}

fun part1(input: List<String>) =
    convertToLineDefinitions(input)
        .filter { it.isVertical() || it.isHorizontal() }
        .map { Line(it) }
        .flatMap { it.positions }
        .groupingBy { it }
        .eachCount()
        .filter { it.value > 1 }
        .count()

fun part2(input: List<String>) =
    convertToLineDefinitions(input)
        .filter { it.isVertical() || it.isHorizontal() || it.isDiagonal() }
        .map { Line(it) }
        .flatMap { it.positions }
        .groupingBy { it }
        .eachCount()
        .filter { it.value > 1 }
        .count()
