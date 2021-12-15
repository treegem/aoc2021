package day04

import readTxtFile
import util.toDayIndex

val dayIndex = 4.toDayIndex()

fun main() {
    val input = readTxtFile("day$dayIndex/Day$dayIndex")
    println(part1(input))
    println(part2(input))
}

fun convertToBingoBoards(input: List<String>) =
    input
        .subList(fromIndex = 2, input.size)
        .asSequence()
        .filterNot(String::isBlank)
        .chunked(5)
        .map { BingoBoard.from(it) }

fun getBingoNumbers(input: List<String>) =
    input
        .first()
        .split(',')
        .map { it.toInt() }

fun part1(input: List<String>): Int {
    val bingoNumbers = getBingoNumbers(input)
    val bingoBoards = convertToBingoBoards(input)
    return 1
}

fun part2(input: List<String>): Int {
    return input.size
}