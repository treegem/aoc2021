package day05

import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import readTxtFile

internal class Day05KtTest {

    private val testInput = readTxtFile("day$dayIndex/Day${dayIndex}_test")

    @Test
    fun partOne__success() {
        part1(testInput) shouldBe 5
    }

    @Test
    fun convertToLineDefinitions__success() {
        val lineDefinitions = convertToLineDefinitions(testInput)

        lineDefinitions shouldHaveSize 10
        lineDefinitions.first() shouldBe LineDefinition(start = Position(0, 9), end = Position(5, 9))
    }


}