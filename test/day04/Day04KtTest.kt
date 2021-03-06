package day04

import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import readTxtFileAsLines

class Day04KtTest {

    private val testInput = readTxtFileAsLines("day$dayIndex/Day${dayIndex}_test")

    @Test
    fun convertToBingoBoards__success() {
        val boards = convertToBingoBoards(testInput)

        boards shouldHaveSize 3
        boards.last().fields.single { it.line == 4 && it.column == 4 }.value shouldBe 7
    }

    @Test
    fun getBingoNumbers__success() {
        val bingoNumbers = getBingoNumbers(testInput)

        bingoNumbers.first() shouldBe 7
        bingoNumbers.last() shouldBe 1
    }

    @Test
    fun partOne__success() {
        part1(testInput) shouldBe 4512
    }

    @Test
    fun partTwo__success() {
        part2(testInput) shouldBe 1924
    }
}