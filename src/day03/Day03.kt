package day03

import readTxtFile
import util.bitwiseInvert

fun main() {
    val dayIndex = 3.toString().padStart(2, '0')

    fun gammaFromInput(input: List<String>, bitAmount: Int): Int {
        var gammaString = ""
        (0 until bitAmount).forEach { i ->
            gammaString += input.map { bitString -> bitString[i] }
                .groupingBy { it }
                .eachCount()
                .maxByOrNull { it.value }!!
                .key
        }
        return gammaString.toInt(2)
    }

    fun epsilonFromGamma(gamma: Int, bitAmount: Int) =
        gamma.bitwiseInvert()
            .toString(2)
            .takeLast(bitAmount)
            .toInt(2)

    fun part1(input: List<String>): Int {
        val bitAmount = input.first().length
        val gamma: Int = gammaFromInput(input, bitAmount)
        val epsilon: Int = epsilonFromGamma(gamma, bitAmount)
        return gamma * epsilon
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readTxtFile("day$dayIndex/Day${dayIndex}_test")
    check(gammaFromInput(testInput, 5) == 22)
    val epsilon = epsilonFromGamma(22, 5)
    check(epsilon == 9) { "epsilon: $epsilon" }
    val part1Result = part1(testInput)
    check(part1(testInput) == 198) { "part 1 result: $part1Result" }

    val input = readTxtFile("day$dayIndex/Day$dayIndex")
    println(part1(input))
    println(part2(input))
}
