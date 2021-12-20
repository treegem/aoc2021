package day05

class Line(private val lineDefinition: LineDefinition) {

    val positions = createPositions()

    private fun createPositions() = when {
        lineDefinition.isVertical() -> createVerticalLineFrom()
        lineDefinition.isHorizontal() -> createHorizontalLineFrom()
        lineDefinition.isDiagonal() -> createDiagonalLineFrom()
        else -> throw IllegalArgumentException("line-definition is corrupt")
    }

    private fun createHorizontalLineFrom(): List<Position> {
        val positions = mutableListOf<Position>()
        getXValues().forEach { x ->
            positions.add(Position(x, lineDefinition.start.y))
        }
        return positions.toList()
    }

    private fun createVerticalLineFrom(): List<Position> {
        val positions = mutableListOf<Position>()
        getYValues().forEach { y ->
            positions.add(Position(lineDefinition.start.x, y))
        }
        return positions.toList()
    }

    private fun createDiagonalLineFrom(): List<Position> {
        val positions = mutableListOf<Position>()
        val xs = getXValues()
        val ys = getYValues()
        xs.indices.forEach { i -> positions.add(Position(xs[i], ys[i])) }
        return positions.toList()
    }

    private fun getXValues(): List<Int> {
        val xStart = lineDefinition.start.x
        val xEnd = lineDefinition.end.x
        return if (xStart <= xEnd) {
            (xStart..xEnd).toList()
        } else {
            (xStart downTo xEnd).toList()
        }
    }

    private fun getYValues(): List<Int> {
        val yStart = lineDefinition.start.y
        val yEnd = lineDefinition.end.y
        return if (yStart <= yEnd) {
            (yStart..yEnd).toList()
        } else {
            (yStart downTo yEnd).toList()
        }
    }
}