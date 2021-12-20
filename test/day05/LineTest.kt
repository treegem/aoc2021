package day05

import io.kotest.matchers.collections.shouldContainExactlyInAnyOrder
import org.junit.jupiter.api.Test

internal class LineTest {

    @Test
    fun create__success__increasingNumbersOnly() {
        val definition = LineDefinition(Position(3, 5), Position(5, 5))

        val line = Line(definition)

        line.positions shouldContainExactlyInAnyOrder listOf(Position(3, 5), Position(4, 5), Position(5, 5))
    }

    @Test
    fun create__success__decreasingX() {
        val definition = LineDefinition(Position(5, 5), Position(3, 5))

        val line = Line(definition)

        line.positions shouldContainExactlyInAnyOrder listOf(Position(3, 5), Position(4, 5), Position(5, 5))
    }

}