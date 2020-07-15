import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    val size = scanner.nextInt()
    val array = IntArray(size)

    for (i in 0..array.lastIndex) {
        array[i] = scanner.nextInt()
    }

    val m = scanner.nextInt()

    var count = 0

    for (i in array.lastIndex downTo 0) {
        if (array[i] == m) count++
    }

    print(count)

    // write your code here
}