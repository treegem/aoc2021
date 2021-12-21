package day03

import readTxtFileAsLines
import util.bitwiseInvert

fun main() {
    val dayIndex = 3.toString().padStart(2, '0')

    fun getBitAmount(input: List<String>) = input.first().length

    fun List<Char>.getMostCommonEntry() = sortedByDescending { it } // if equal amount of entries, take the highest key
        .groupingBy { it }
        .eachCount()
        .maxByOrNull { it.value }!!
        .key

    //region part 1 only
    fun gammaFromInput(input: List<String>, bitAmount: Int): Int {
        var gammaString = ""
        (0 until bitAmount).forEach { i ->
            gammaString += input.map { bitString -> bitString[i] }.getMostCommonEntry()
        }
        return gammaString.toInt(2)
    }

    fun epsilonFromGamma(gamma: Int, bitAmount: Int) =
        gamma.bitwiseInvert()
            .toString(2)
            .takeLast(bitAmount)
            .toInt(2)

    fun part1(input: List<String>): Int {
        val bitAmount = getBitAmount(input)
        val gamma: Int = gammaFromInput(input, bitAmount)
        val epsilon: Int = epsilonFromGamma(gamma, bitAmount)
        return gamma * epsilon
    }
    //endregion

    //region part 2 only
    fun determineMostCommonBitAtIndex(currentBitIndex: Int, remainingResults: List<String>): Char =
        remainingResults.map { it[currentBitIndex] }.getMostCommonEntry()

    fun getOxygen(input: List<String>): Int {
        val bitAmount = getBitAmount(input)
        var currentBitIndex = 0
        val remainingResults = input.toMutableList()
        while (remainingResults.size > 1) {
            val mostCommonBit = determineMostCommonBitAtIndex(currentBitIndex, remainingResults)
            remainingResults.removeIf { bits -> bits[currentBitIndex] != mostCommonBit }
            currentBitIndex = (currentBitIndex + 1) % bitAmount
        }
        return remainingResults.single().toInt(2)
    }

    fun determineLeastCommonBitAtIndex(currentBitIndex: Int, remainingResults: List<String>) =
        when (determineMostCommonBitAtIndex(currentBitIndex, remainingResults)) {
            '1' -> '0'
            else -> '1'
        }

    fun getCarbon(input: List<String>): Int {
        val bitAmount = getBitAmount(input)
        var currentBitIndex = 0
        val remainingResults = input.toMutableList()
        while (remainingResults.size > 1) {
            val leastCommonBit = determineLeastCommonBitAtIndex(currentBitIndex, remainingResults)
            remainingResults.removeIf { bits -> bits[currentBitIndex] != leastCommonBit }
            currentBitIndex = (currentBitIndex + 1) % bitAmount
        }
        return remainingResults.single().toInt(2)
    }

    fun part2(input: List<String>) = getOxygen(input) * getCarbon(input)
    //endregion

    // test if implementation meets criteria from the description, like:
    val testInput = readTxtFileAsLines("day$dayIndex/Day${dayIndex}_test")

    //region part 1 tests
    check(gammaFromInput(testInput, 5) == 22)
    val epsilon = epsilonFromGamma(22, 5)
    check(epsilon == 9) { "epsilon: $epsilon" }
    val part1Result = part1(testInput)
    check(part1(testInput) == 198) { "part 1 result: $part1Result" }
    //endregion

    //region part 2 tests
    check(determineMostCommonBitAtIndex(0, testInput) == '1')
    check(getOxygen(testInput) == 23)
    check(determineLeastCommonBitAtIndex(0, testInput) == '0')
    check(getCarbon(testInput) == 10)
    //endregion

    val input = readTxtFileAsLines("day$dayIndex/Day$dayIndex")
    println(part1(input))
    println(part2(input))
}
