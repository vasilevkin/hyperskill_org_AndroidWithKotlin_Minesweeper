import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    val size = scanner.nextInt()

    val array = IntArray(size)

    for (i in 0..array.lastIndex) {
        array[i] = scanner.nextInt()
    }

    var numberOfTriples = 0

    for (i in 2..array.lastIndex) {
        if (array[i - 1] == array[i] - 1 && array[i - 2] == array[i] - 2) numberOfTriples++
    }

    print(numberOfTriples)

    // write your code here
}