import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val a = scanner.nextBigInteger()
    val b = scanner.nextBigInteger()
    val c = scanner.nextBigInteger()

    val array = arrayOf(a, b, c)
    for (i in 1..3) {

    }

    print(when {
        a == b && b == c -> 3
        a == b -> 2
        else -> 0

    })
    // write your code here
}