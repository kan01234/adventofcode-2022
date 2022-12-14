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

    println(listOf(20, 60, 100, 140, 180, 220).map { signals[it - 1] * it }.sum())
}
