package day7

import java.io.File
import java.io.InputStream

fun main() {
    val inputStream: InputStream = File("input/d7-input.txt").inputStream()

    var result = 0
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

    println(files.filter { entry -> entry.value <= 100000L }.values.sum())
}