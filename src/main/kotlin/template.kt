import java.io.File
import java.io.InputStream

fun main() {
    val inputStream: InputStream = File("input/d-input.txt").inputStream()

    var result = 0
    for (line in inputStream.bufferedReader().readLines()) {
    }

    println(result)
}
