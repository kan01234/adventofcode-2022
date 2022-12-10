package day7

import java.io.File
import java.io.InputStream
import kotlin.math.abs

fun main() {
    val inputStream: InputStream = File("input/d7-input.txt").inputStream()

    var result = 0L
    val files = mutableMapOf<String, Long>()
    val stack = ArrayDeque<String>()

    for (line in inputStream.bufferedReader().readLines()) {
        if (line == "$ cd ..") {
            stack.removeLast()
            continue
        }

        if (line.startsWith("$ cd ")) {
            val key = stack.joinToString("/") + line.replace("$ cd ", "")
            files[key] = 0L
            stack.add(key)
            continue
        }

        if (line.toCharArray()[0] in '0'..'9') {
            val size = line.split(" ")[0].toLong()
            for (d in stack) {
                files[d] = files[d]!! + size
            }
        }
    }

    val need = abs(70000000 - files["/"]!! - 30000000)
    println(files.filter { entry -> entry.value >= need }.values.min())
}