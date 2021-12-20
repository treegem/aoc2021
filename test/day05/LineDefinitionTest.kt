package day05

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

internal class LineDefinitionTest {

    @Test
    fun isHorizontal__success() {
        val definition = LineDefinition(Position(3, 5), Position(1, 5))

        definition.isHorizontal() shouldBe true
        definition.isVertical() shouldBe false
        definition.isDiagonal() shouldBe false
    }

    @Test
    fun isVertical__success() {
        val definition = LineDefinition(Position(3, 5), Position(3, 15))

        definition.isHorizontal() shouldBe false
        definition.isVertical() shouldBe true
        definition.isDiagonal() shouldBe false
    }

    @Test
    fun definesVerticalLine__success() {
        val definition = LineDefinition(Position(3, 3), Position(6, 0))

        definition.isHorizontal() shouldBe false
        definition.isVertical() shouldBe false
        definition.isDiagonal() shouldBe true
    }

}