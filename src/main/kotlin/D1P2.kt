import java.io.File
import java.io.InputStream

/**
 * file for day 1
 */
fun main(args: Array<String>) {
    val inputStream: InputStream = File("input/d1-input.txt").inputStream()

    var sums = arrayListOf<Int>()
    var sum = 0
    for (line in inputStream.bufferedReader().readLines()) {
        if (line.isBlank()) {
            sums.add(sum)
            sum = 0
            continue
        }
        sum += line.toInt()
    }
    sums.add(sum)
    sums.sortDescending()
    println(sums.subList(0, 3).sum())
}