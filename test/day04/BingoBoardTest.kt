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

        val result = BingoBoard.from(input)

        result.fields shouldHaveSize 25
        result.fields.single { it.line == 1 && it.column == 4 }.value shouldBe 24
    }
}