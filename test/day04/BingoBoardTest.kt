package day04

import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class BingoBoardTest {

    @Test
    fun createFromString() {
        val input = listOf(
            "22 13 17 11  0",
            "8  2 23  4 24",
            "21  9 14 16  7",
            "6 10  3 18  5",
            "1 12 20 15 19"
        )

        val result = BingoBoard.fromStrings(input)

        result.fields shouldHaveSize 25
        result.fields.single { it.line == 1 && it.column == 4 }.value shouldBe 24
    }

    @Test
    fun hasBingo__ignoreDiagonalBingo() {
        val fields = listOf(
            BingoField(line = 0, column = 0, marked = true),
            BingoField(line = 0, column = 1, marked = false),
            BingoField(line = 1, column = 0, marked = false),
            BingoField(line = 1, column = 1, marked = true)
        )
        val board = BingoBoard(fields)

        board.hasBingo() shouldBe false
    }

    @Test
    fun hasBingo__bingoInLine() {
        val fields = listOf(
            BingoField(line = 0, column = 0, marked = true),
            BingoField(line = 0, column = 1, marked = true),
            BingoField(line = 1, column = 0, marked = false),
            BingoField(line = 1, column = 1, marked = false)
        )
        val board = BingoBoard(fields)

        board.hasBingo() shouldBe true
    }

    @Test
    fun hasBingo__bingoInColumn() {
        val fields = listOf(
            BingoField(line = 0, column = 0, marked = true),
            BingoField(line = 0, column = 1, marked = false),
            BingoField(line = 1, column = 0, marked = true),
            BingoField(line = 1, column = 1, marked = false)
        )
        val board = BingoBoard(fields)

        board.hasBingo() shouldBe true
    }

    @Test
    fun call_success() {
        val fields = listOf(
            BingoField(line = 0, column = 0, value = 1, marked = false),
            BingoField(line = 0, column = 1, value = 2, marked = false),
            BingoField(line = 1, column = 0, value = 3, marked = false),
            BingoField(line = 1, column = 1, value = 4, marked = false)
        )
        val board = BingoBoard(fields)

        board.call(3)

        board.fields.single { it.line == 1 && it.column == 0 }.marked shouldBe true
        board.fields.filterNot { it.line == 1 && it.column == 0 }.any { it.marked } shouldBe false
    }
}