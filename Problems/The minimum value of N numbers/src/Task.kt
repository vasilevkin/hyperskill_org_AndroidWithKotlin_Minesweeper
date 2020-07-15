import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val quantity = scanner.nextInt()
    var min = Int.MAX_VALUE

    repeat(quantity) {
        val number = scanner.nextInt()
        if (number < min) min = number
    }
    print(min)
    // write your code here
}