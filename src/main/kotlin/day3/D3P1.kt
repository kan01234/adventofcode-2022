import java.io.File
import java.io.InputStream

fun main(args: Array<String>) {
    val inputStream: InputStream = File("input/d3-input.txt").inputStream()

    var result = 0
    var lines = arrayListOf<String>()
    for (line in inputStream.bufferedReader().readLines()) {
        lines.add(line)
        if (lines.size < 3)
            continue

        val firsts = lines[0].toCharArray().toSet()
        val seconds = lines[1].toCharArray().toSet()
        for (c in lines[2].toCharArray().toSet()) {
            if (firsts.contains(c) && seconds.contains(c)) {
                result += if (c.code > 96) {
                    c.code - 'a'.code + 1
                } else {
                    c.code - 'A'.code + 27
                }
            }
        }
        lines = arrayListOf<String>()
    }

    println(result)
}
