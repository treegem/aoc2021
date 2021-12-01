package day01

import readTxtFile

fun main() {
    fun countIncreases(numbers: List<Int>): Int {
        var numberOfIncreases = 0
        (1 until numbers.size).forEach { i ->
            if (numbers[i] > numbers[i - 1]) {
                numberOfIncreases += 1
            }
        }
        return numberOfIncreases
    }

    fun sumTriples(numbers: List<Int>): List<Int> {
        val sums = mutableListOf<Int>()
        (0..numbers.size - 3).forEach { i ->
            sums.add(numbers[i] + numbers[i + 1] + numbers[i + 2])
        }
        return sums
    }

    fun part1(input: List<String>): Int {
        val numbersList = input.map(String::toInt)
        return countIncreases(numbersList)
    }

    fun part2(input: List<String>): Int {
        val numbersList = input.map(String::toInt)
        val sumsList = sumTriples(numbersList)
        return countIncreases(sumsList)
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readTxtFile("day01/Day01_test")
    check(part1(testInput) == 7) { "wrong number: " + part1(testInput) }
    check(sumTriples(listOf(1, 2, 3, 4)) == listOf(6, 9))
    check(part2(testInput) == 5) { "part two failed with wrong number: " + part2(testInput) }

    val input = readTxtFile("day01/Day01")
    println(part1(input))
    println(part2(input))

}
