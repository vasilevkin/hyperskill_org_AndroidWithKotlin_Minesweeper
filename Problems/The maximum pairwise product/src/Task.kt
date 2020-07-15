import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    val quantity = scanner.nextInt()

    val numbers = IntArray(quantity)
    repeat(quantity) {
        numbers[it] = scanner.nextInt()
    }

    numbers.sort()

    if (numbers.size > 1)
        print(numbers.last() * (numbers[numbers.lastIndex - 1]))
    else
        print(numbers.first())


    // write your code here
}