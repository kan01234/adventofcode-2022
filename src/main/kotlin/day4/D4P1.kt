import java.io.File
import java.io.InputStream

fun main() {
    val inputStream: InputStream = File("input/d4-input.txt").inputStream()

    var result = 0
    for (line in inputStream.bufferedReader().readLines()) {
        val arr = line.split(',')
        val p1 = arr[0].split('-').map { it -> it.toInt() }
        val p2 = arr[1].split('-').map { it -> it.toInt() }

        val min = p1[0].coerceAtMost(p2[0])
        val max = p1[1].coerceAtLeast(p2[1])

        if (
            (min == p1[0] && max == p1[1]) ||
            (min == p2[0] && max == p2[1])
        )
            result += 1
    }

    println(result)
}
