package day04

import readTxtFile
import util.toDayIndex

val dayIndex = 4.toDayIndex()

fun main() {
    val input = readTxtFile("day$dayIndex/Day$dayIndex")
    println(part1(input))
    println(part2(input))
}

fun part1(input: List<String>): Int {
    val bingoBoards = convertToBingoBoards(input)
    getBingoNumbers(input).forEach() { bingoNumber ->
        bingoBoards.forEach { bingoBoard ->
            bingoBoard.call(bingoNumber)
        }
        val boardWithBingo = bingoBoards.firstOrNull(BingoBoard::hasBingo)
        if (boardWithBingo != null) {
            return sumUnmarkedFieldValues(boardWithBingo) * bingoNumber
        }
    }
    throw IllegalArgumentException("given input yields no bingo")
}

fun part2(input: List<String>): Int {
    val bingoBoards = convertToBingoBoards(input).toMutableList()
    getBingoNumbers(input).forEach() { bingoNumber ->
        bingoBoards.forEach { bingoBoard ->
            bingoBoard.call(bingoNumber)
        }
        if (bingoBoards.size == 1 && bingoBoards.all(BingoBoard::hasBingo)) {
            return sumUnmarkedFieldValues(bingoBoards.single()) * bingoNumber
        }
        bingoBoards.removeAll(BingoBoard::hasBingo)
    }
    throw IllegalArgumentException("given input yields no single last bingo board")
}