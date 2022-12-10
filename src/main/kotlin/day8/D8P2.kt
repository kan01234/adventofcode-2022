package day8

import java.io.File
import java.io.InputStream

fun main() {
    val inputStream: InputStream = File("input/d8-input.txt").inputStream()

    val trees = mutableListOf<List<Int>>()
    for (line in inputStream.bufferedReader().readLines()) {
        trees.add(line.toCharArray().toList().map { it -> it.toString().toInt() })
    }

    val scores = mutableListOf<Int>()

    for (i in 1 until trees.size - 1) {
        val row = trees[i]
        for  (j in 1 until row.size - 1) {
            // current tree value
            val cur = trees[i][j]

            // visible from left
            var leftCount = 0
            for (left in row.subList(0, j).reversed()) {
                leftCount++
                if (cur <= left)
                    break
            }

            // right
            var rightCount = 0
            for (right in  row.subList(j + 1, row.size)) {
                rightCount++
                if (cur <= right)
                    break
            }

            // setup column list
            val column = mutableListOf<Int>()
            for (k in trees.indices) {
                column.add(trees[k][j])
            }

            // top
            var topCount = 0
            for (top in column.subList(0, i).reversed()) {
                topCount++
                if (cur <= top)
                    break
            }

            // bottom
            var bottomCount = 0
            for (bottom in column.subList(i + 1, column.size)) {
                bottomCount++
                if (cur <= bottom)
                    break
            }

            scores.add(leftCount * rightCount * topCount * bottomCount)
        }
    }

    println(scores.max())
}
