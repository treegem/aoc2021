import java.io.File

/**
 * Reads lines from the given input txt file.
 */
fun readTxtFile(name: String) = File("src", "$name.txt").readLines()