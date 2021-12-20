package day05

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class LineDefinitionTest {

    @Test
    fun definesHorizontalLine__success() {
        val definition = LineDefinition(Position(3, 5), Position(1, 5))

        definition.definesHorizontalLine() shouldBe true
        definition.definesVerticalLine() shouldBe false
    }

    @Test
    fun definesVerticalLine__success() {
        val definition = LineDefinition(Position(3, 5), Position(3, 15))

        definition.definesHorizontalLine() shouldBe false
        definition.definesVerticalLine() shouldBe true
    }

}