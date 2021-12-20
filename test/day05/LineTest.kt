package day05

import io.kotest.matchers.collections.shouldContainExactlyInAnyOrder
import org.junit.jupiter.api.Test

internal class LineTest {

    @Test
    fun create__success__horizontalIncreasingNumbersOnly() {
        val definition = LineDefinition(Position(3, 5), Position(5, 5))

        val line = Line(definition)

        line.positions shouldContainExactlyInAnyOrder listOf(Position(3, 5), Position(4, 5), Position(5, 5))
    }

    @Test
    fun create__success__verticalDecreasingX() {
        val definition = LineDefinition(Position(3, 5), Position(3, 3))

        val line = Line(definition)

        line.positions shouldContainExactlyInAnyOrder listOf(Position(3, 3), Position(3, 4), Position(3, 5))
    }

    @Test
    fun create__success__diagonalDecreasingY() {
        val definition = LineDefinition(Position(3, 3), Position(6, 0))

        val line = Line(definition)

        line.positions shouldContainExactlyInAnyOrder listOf(
            Position(3, 3),
            Position(4, 2),
            Position(5, 1),
            Position(6, 0)
        )
    }

}