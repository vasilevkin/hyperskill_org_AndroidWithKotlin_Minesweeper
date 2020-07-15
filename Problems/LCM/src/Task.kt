import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val a = scanner.nextBigInteger()
    val b = scanner.nextBigInteger()
    val result = (a * b) / a.gcd(b)

    print(result)
    // write your code here
}