import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    val size = scanner.nextInt()
    val array = IntArray(size)

    for (i in 0..array.lastIndex) {
        array[i] = scanner.nextInt()
    }

    val m = scanner.nextInt()

    var iSmInArray = false

    for (i in 0..array.lastIndex) {
        if (array[i] == m) iSmInArray = true
    }
    print(if (iSmInArray) "YES" else "NO")



    // write your code here
}