import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    val n1 = scanner.nextInt()
    val n2 = scanner.nextInt()
    val n3 = scanner.nextInt()

    val desks = (n1 + 1) / 2 + (n2 + 1) / 2 + (n3 + 1) / 2

    print(desks)

    // put your code here
}