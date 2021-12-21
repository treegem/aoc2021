import java.io.File

/**
 * Reads lines from the given input txt file.
 */
fun readTxtFileAsLines(name: String) = File("src", "$name.txt").readLines()

/**
 * Reads as single string from the given input txt file.
 */
fun readTxtFileAsString(name: String) = File("src", "$name.txt").readText()