import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    val n1 = scanner.nextInt()
    val n2 = scanner.nextInt()

    var sum = 0
    for (i in n1..n2) sum += i

    print(sum)
    // put your code here
}