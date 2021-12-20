package day05

class Line(lineDefinition: LineDefinition) {
    val positions = positionsFrom(lineDefinition)

    private fun positionsFrom(lineDefinition: LineDefinition): List<Position> {
        val positions = mutableListOf<Position>()
        val xs = listOf(lineDefinition.start.x, lineDefinition.end.x)
        val ys = listOf(lineDefinition.start.y, lineDefinition.end.y)
        (xs.minOf { it }..xs.maxOf { it }).forEach { x ->
            (ys.minOf { it }..ys.maxOf { it }).forEach { y ->
                positions.add(Position(x, y))
            }
        }
        return positions.toList()
    }
}