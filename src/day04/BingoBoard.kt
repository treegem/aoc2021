package day04

class BingoBoard(val fields: List<BingoField>) {

    fun call(number: Int) {
        TODO()
    }

    fun hasBingo(): Boolean {
        TODO()
    }

    companion object {
        fun from(strings: List<String>): BingoBoard {
            val intLines = strings.map { convertToListOfInts(it) }
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
                .filterNot { it.isBlank() }
                .map { it.trim() }
                .map { it.toInt() }
    }

}