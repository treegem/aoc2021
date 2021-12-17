package day04

@Suppress("DuplicatedCode")
class BingoBoard(val fields: List<BingoField>) {

    fun call(number: Int) {
        val calledFields = fields.filter { it.value == number }
        calledFields.forEach { field ->
            field.apply { marked = true }
        }
    }

    fun hasBingo(): Boolean {
        return isAnyLineFullyMarked() || isAnyColumnFullyMarked()
    }

    private fun isAnyColumnFullyMarked(): Boolean {
        val columnIndices = fields.map { it.column }.toSet()
        val columnBingos = columnIndices.map { columnIndex ->
            val columnFields = fields.filter { it.column == columnIndex }
            columnFields.all { it.marked }
        }
        return columnBingos.any { it }
    }

    private fun isAnyLineFullyMarked(): Boolean {
        val lineIndices = fields.map { it.line }.toSet()
        val lineBingos = lineIndices.map { lineIndex ->
            val lineFields = fields.filter { it.line == lineIndex }
            lineFields.all { it.marked }
        }
        return lineBingos.any { it }

    }

    companion object BoardFactory {
        fun fromStrings(strings: List<String>): BingoBoard {
            val intLines = strings.map(::convertToListOfInts)
            val bingoFields = convertToBingoFields(intLines)
            return BingoBoard(bingoFields)
        }

        private fun convertToBingoFields(intLines: List<List<Int>>) =
            intLines.mapIndexed { lineIndex, intLine ->
                intLine.mapIndexed { columnIndex, fieldValue ->
                    BingoField(
                        line = lineIndex,
                        column = columnIndex,
                        value = fieldValue
                    )
                }
            }.flatten()

        private fun convertToListOfInts(stringLine: String) =
            stringLine
                .split(" ")
                .filterNot(String::isBlank)
                .map(String::trim)
                .map(String::toInt)
    }

}