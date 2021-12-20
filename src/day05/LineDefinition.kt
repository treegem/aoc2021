package day05

data class LineDefinition(
    val start: Position,
    val end: Position,
) {
    fun definesHorizontalLine() = start.y == end.y

    fun definesVerticalLine() = start.x == end.x
}
