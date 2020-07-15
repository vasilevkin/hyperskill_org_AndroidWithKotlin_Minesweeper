import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val a = scanner.nextBigInteger()
    val b = scanner.nextBigInteger()

    val sum = a + b
    val aPercent = a * 100.toBigInteger() / sum
    val bPercent = b * 100.toBigInteger() / sum

    print("$aPercent% $bPercent%")
    // write your code here
}
