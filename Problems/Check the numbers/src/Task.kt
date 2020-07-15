import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    val size = scanner.nextInt()

    val array = IntArray(size)

    for (i in 0..array.lastIndex) {
        array[i] = scanner.nextInt()
    }

    val n = scanner.nextInt()
    val m = scanner.nextInt()

    var nAndmNext = false

    for (i in 1..array.lastIndex) {
        if (array[i-1] == n && array[i] == m) nAndmNext = true
        if (array[i-1] == m && array[i] == n) nAndmNext = true
    }

    print(if (!nAndmNext) "YES" else "NO")
    // write your code here
}