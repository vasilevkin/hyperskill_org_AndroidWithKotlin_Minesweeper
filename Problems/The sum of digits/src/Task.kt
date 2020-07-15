import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val number = scanner.nextInt()
    val sum = number / 100 % 10 + number / 10 % 10 + number % 10

    print(sum)
}