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
    // X means you need to lose, Y means you need to end the round in a draw, and Z means you need to win
    val wons = mapOf<String, String>(
        "A" to "Y",
        "B" to "Z",
        "C" to "X"
    )

    val map = mapOf<String, Map<String, Int>>(
        // rock
        "A" to mapOf<String, Int>(
            // lose
            "X" to 3 + 0,
            // draw
            "Y" to 1 + 3,
            // win
            "Z" to 2 + 6
        ),
        // paper
        "B" to mapOf<String, Int>(
            "X" to 1 + 0,
            "Y" to 2 + 3,
            "Z" to 3 + 6
        ),
        // scissor
        "C" to mapOf<String, Int>(
            "X" to 2 + 0,
            "Y" to 3 + 3,
            "Z" to 1 + 6
        ),
    )

    var result = 0
    for (line in inputStream.bufferedReader().readLines()) {
        val arr = line.split(" ")
        result += map[arr[0]]!![arr[1]]!!
    }
    print(result)
}
