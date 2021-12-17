package day04

data class BingoField(
    val line: Int,
    val column: Int,
    val value: Int = 0,
    var marked: Boolean = false
)