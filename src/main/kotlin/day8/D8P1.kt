package day8

import java.io.File
import java.io.InputStream

fun main() {
    val inputStream: InputStream = File("input/d8-input.txt").inputStream()

    val trees = mutableListOf<List<Int>>()
    var result = 0
    for (line in inputStream.bufferedReader().readLines()) {
        trees.add(line.toCharArray().toList().map { it -> it.toString().toInt() })
    }

    // edge
    result += trees.size * 2 + trees[0].size * 2 - 4

    for (i in 1 until trees.size - 1) {
        val row = trees[i]
        for  (j in 1 until row.size - 1) {
            // current tree value
            val cur = trees[i][j]

            // visible from left
            if (cur > row.subList(0, j).max()) {
                result += 1
                continue
            }

            // right
            if (cur > row.subList(j + 1, row.size).max()) {
                result += 1
                continue
            }

            // setup column list
            val column = mutableListOf<Int>()
            for (k in trees.indices) {
                column.add(trees[k][j])
            }

            // top
            if (cur > column.subList(0, i).max()) {
                result += 1
                continue
            }

            // bottom
            if (cur > column.subList(i + 1, column.size).max()) {
                result += 1
                continue
            }
        }
    }

    println(result)
}
