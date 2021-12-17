package day05

fun convertToLineDefinitions(input: List<String>) =
    input.map { inputString ->
        val (startString, endString) = inputString.split(" -> ")
        LineDefinition(
            start = convertToPosition(startString),
            end = convertToPosition(endString)
        )
    }

private fun convertToPosition(position: String): Position {
    val (x, y) = position.split(",")
    return Position(x.toInt(), y.toInt())
}
