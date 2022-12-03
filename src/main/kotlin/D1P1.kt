import java.io.File
import java.io.InputStream

/**
 * file for day 1
 */
fun main(args: Array<String>) {
    val inputStream: InputStream = File("input/d1-input.txt").inputStream()

    var result = 0
    var sum = 0
    for (line in inputStream.bufferedReader().readLines()) {
        if (line.isBlank()) {
            result = Math.max(sum, result)
            sum = 0
            continue
        }
        sum += line.toInt()
    }
    result = Math.max(sum, result)

    println(result)
}