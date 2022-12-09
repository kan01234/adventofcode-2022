import java.io.File
import java.io.InputStream

fun main(args: Array<String>) {
    val inputStream: InputStream = File("input/d2-input.txt").inputStream()
    // won = 6, draw = 3, lose = 0
    // 1 for Rock, 2 for Paper, and 3 for Scissors

    // request: A for Rock, B for Paper, C for Scissors
    // response: X for Rock, Y for Paper, and Z for Scissors
    val responses = mapOf<String, Int>(
        "X" to 1,
        "Y" to 2,
        "Z" to 3,
    )
    val requests = mapOf<String, String>(
        "A" to "X",
        "B" to "Y",
        "C" to "Z"
    )
    val wons = mapOf<String, String>(
        "A" to "Y",
        "B" to "Z",
        "C" to "X"
    )
    var result = 0
    for (line in inputStream.bufferedReader().readLines()) {
        val arr = line.split(" ")
        result += responses.get(arr[1])!!
        if (requests.get(arr[0]) == arr[1]) {
            result += 3
            continue
        }
        if (wons.get(arr[0]) == arr[1])
            result += 6
    }
    print(result)
}
