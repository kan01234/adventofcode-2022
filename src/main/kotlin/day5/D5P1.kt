import java.io.File
import java.io.InputStream

// SHMSDGZVC

fun main() {
    val inputStream: InputStream = File("input/d5-input.txt").inputStream()

    val crates = Array<MutableList<Char>>(9) { _ -> mutableListOf() }

    var isMove = false
    for (line in inputStream.bufferedReader().readLines()) {
        if (line == "") {
            isMove = true
            continue
        }

        if (!isMove) {
            val chars = line.toCharArray()
            for (i in chars.indices) {
                val char = chars[i]
                if (char < 'A' || char > 'Z')
                    continue
                crates[(i - 1) / 4].add(char)
            }
        }

        if (isMove) {
            val arr = line.split(' ')
            val q = arr[1].trim().toInt()
            val s = arr[3].trim().toInt() - 1
            val d = arr[5].trim().toInt() - 1

            for (i in 1..q) {
                crates[d].add(0, crates[s].removeFirst())
            }
        }
    }

    for (crate in crates) {
        print(crate.first())
    }
}
