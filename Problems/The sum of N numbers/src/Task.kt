import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    val quantity = scanner.nextInt()

    var sum = 0
    repeat(quantity) {
        val number = scanner.nextInt()

        sum += number
    }

    print(sum)

    // write your code here
}