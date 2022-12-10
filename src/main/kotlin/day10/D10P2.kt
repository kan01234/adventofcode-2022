package day10

import java.io.File
import java.io.InputStream

fun main() {
    val inputStream: InputStream = File("input/d10-input.txt").inputStream()

    // starting is 1
    val signals = mutableListOf<Int>(1)

    for (line in inputStream.bufferedReader().readLines()) {
        val arr = line.split(" ")
        signals.add(signals.last())

        if (arr.size >= 2) {
            signals.add(signals.last() + arr[1].toInt())
        }
    }

    var sprites = sprites(1)
    var output = ""

    for (i in 1 until signals.size) {

        output += if (sprites.contains((i - 1) % 40))
            "#"
        else
            " "

        if (signals[i] != signals[i - 1])
            sprites = sprites(signals[i])
    }
    println(output.chunked(40).joinToString("\n"))
}

fun sprites(p: Int): Set<Int> {
    return setOf<Int>(p - 1, p, p + 1)
}
