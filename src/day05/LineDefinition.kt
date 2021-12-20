package day05

import kotlin.math.absoluteValue

data class LineDefinition(
    val start: Position,
    val end: Position,
) {
    fun isHorizontal() = start.y == end.y

    fun isVertical() = start.x == end.x

    fun isDiagonal() = (start.x - end.x).absoluteValue == (start.y - end.y).absoluteValue
    
}
