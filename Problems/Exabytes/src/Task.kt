import java.math.BigInteger
import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val a = scanner.nextBigInteger()

    val exa: BigInteger = BigInteger("2").pow(63)
    val result = a * exa
//    val result = a * BigInteger("9223372036854775808")

    print(result)
    // write your code here
}