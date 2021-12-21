package day02

import readTxtFileAsLines

fun main() {
    fun calculateFinalPositionWithoutAim(input: List<String>): SimplePosition =
        input.map { command -> SimplePosition.fromCommand(command) }
            .reduce { summedPositions, position -> summedPositions + position }

    fun calculateFinalPositionWithAim(input: List<String>): PositionWithAim {
        val position = PositionWithAim()
        input.forEach { command -> position.performCommand(command) }
        return position
    }

    fun part1(input: List<String>): Int {
        val position = calculateFinalPositionWithoutAim(input)
        return position.horizontal * position.depth
    }

    fun part2(input: List<String>): Int {
        val position = calculateFinalPositionWithAim(input)
        return position.horizontal * position.depth
    }

// test if implementation meets criteria from the description, like:
    val testInput = readTxtFileAsLines("day02/Day02_test")
    val part1Result = part1(testInput)
    check(part1Result == 150) { "part 1 result: $part1Result" }
    val part2Result = part2(testInput)
    check(part2Result == 900) { "part 2 result: $part2Result" }

    val input = readTxtFileAsLines("day02/Day02")
    println(part1(input))
    println(part2(input))
}

class SimplePosition(val horizontal: Int = 0, val depth: Int = 0) {

    companion object {
        fun fromCommand(command: String): SimplePosition {
            val (direction, stepSizeString) = command.split(" ")
            val stepSize = stepSizeString.toInt()
            return when (direction) {
                "forward" -> SimplePosition(stepSize, 0)
                "up" -> SimplePosition(0, -stepSize)
                "down" -> SimplePosition(0, stepSize)
                else -> throw IllegalArgumentException("invalid direction $direction")
            }
        }
    }

    operator fun plus(other: SimplePosition) =
        SimplePosition(horizontal = horizontal + other.horizontal, depth = depth + other.depth)
}

class PositionWithAim(var horizontal: Int = 0, var depth: Int = 0, var aim: Int = 0) {

    fun performCommand(command: String) {
        val (direction, steps) = command.split(" ")
        when (direction) {
            "forward" -> moveForward(steps)
            "up" -> aimUp(steps)
            "down" -> aimDown(steps)
            else -> throw IllegalArgumentException("invalid direction $direction")
        }
    }

    fun aimDown(steps: String) {
        aim += steps.toInt()
    }

    fun aimUp(steps: String) {
        aim -= steps.toInt()
    }

    fun moveForward(steps: String) {
        val stepsInt = steps.toInt()
        horizontal += stepsInt
        depth += stepsInt * aim
    }
}