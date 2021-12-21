package day06

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import readTxtFileAsString

internal class Day06KtTest {

    private val testInput = readTxtFileAsString("day$dayIndex/Day${dayIndex}_test")

    @Test
    fun partOne__exampleInput() {
        part1(testInput) shouldBe 5934
    }

    @Test
    fun partTwo__exampleInput() {
        part2(testInput) shouldBe 26984457539
    }

    @Test
    fun passDays__zeroDays__noReproduction() {
        val timers = mutableMapOf(
            1 to 1L,
            2 to 1L,
            3 to 1L
        )

        passDays(0, timers)

        val expected = mutableMapOf(
            1 to 1L,
            2 to 1L,
            3 to 1L
        )
        timers shouldBe expected
    }

    @Test
    fun passDays__oneDay__noReproduction() {
        val timers = mutableMapOf(
            1 to 1L,
            2 to 1L,
            3 to 1L
        )

        passDays(1, timers)

        val expected = mutableMapOf(
            0 to 1L,
            1 to 1L,
            2 to 1L,
            3 to 0L,
            4 to 0L,
            5 to 0L,
            6 to 0L,
            7 to 0L,
            8 to 0L
        )
        timers shouldBe expected
    }

    @Test
    fun passDays__oneDay__withReproduction() {
        val timers = mutableMapOf(
            0 to 1L,
            1 to 1L,
            2 to 1L
        )

        passDays(1, timers)

        val expected = mutableMapOf(
            0 to 1L,
            1 to 1L,
            2 to 0L,
            3 to 0L,
            4 to 0L,
            5 to 0L,
            6 to 1L,
            7 to 0L,
            8 to 1L
        )
        timers shouldBe expected
    }

}