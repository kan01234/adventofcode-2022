import java.io.File
import java.io.InputStream

fun main() {
    val inputStream: InputStream = File("input/d6-input.txt").inputStream()

    var result = 0
    val charArray = inputStream.bufferedReader().readLine().toCharArray()
    var chars = mutableListOf<Char>()

    for (i in charArray.indices) {
        val c = charArray[i]
        val index = chars.indexOf(c)
        if (index >= 0) {
            chars = chars.subList(index + 1, chars.size)
        }
        chars.add(c)
        if (chars.size == 14) {
            result = i + 1
            break
        }
    }
    println(result)
}
