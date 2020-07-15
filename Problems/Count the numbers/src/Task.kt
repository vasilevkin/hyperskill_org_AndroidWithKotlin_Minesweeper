import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    val rangeDown = scanner.nextInt()
    val rangeUp = scanner.nextInt()
    val division = scanner.nextInt()

    var result = 0

    for (i in rangeDown..rangeUp) {
        if (i % division == 0) result++
    }

    print(result)

    // put your code here
}