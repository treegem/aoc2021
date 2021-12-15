package day04

data class BingoField(
    val line: Int,
    val column: Int,
    val value: Int,
    var marked: Boolean = false
)