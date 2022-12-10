package day10

import java.io.File
import java.io.InputStream

fun main() {
    val inputStream: InputStream = File("input/d10-input.txt").inputStream()

    var round = 0
    val strengthSet = setOf(20, 60, 100, 140, 180, 220)
    val operations = mutableMapOf<Int, Int>()

    for (line in inputStream.bufferedReader().readLines()) {
        round ++
        if (line != "noop") {
            operations[round + 2 + operations.size] = line.replace("addx ", "").toInt()
        }
    }

    round = 0
    // init value of X
    var result = 0
    var x = 1
    while (operations.isNotEmpty()) {
        round++

        if (operations.containsKey(round)) {
            x += operations[round]!!
            operations.remove(round)
        }

        if (strengthSet.contains(round))
            result += x * round
    }

    println(result)
}
