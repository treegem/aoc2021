package day04

fun convertToBingoBoards(input: List<String>) =
    input
        .subList(fromIndex = 2, input.size)
        .asSequence()
        .filterNot(String::isBlank)
        .chunked(5)
        .map(BingoBoard.BoardFactory::fromStrings)
        .toList()

fun getBingoNumbers(input: List<String>) =
    input
        .first()
        .split(',')
        .map(String::toInt)

fun sumUnmarkedFieldValues(board: BingoBoard) =
    board.fields
        .filterNot { it.marked }
        .sumOf { it.value }