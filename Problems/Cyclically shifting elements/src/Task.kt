import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    val size = scanner.nextInt()
    val array = IntArray(size)

    for (i in 0..array.lastIndex) {
        array[i] = scanner.nextInt()
    }

    val newArray = IntArray(size)

    for (i in 1..array.lastIndex) {

        newArray[i] = array[i-1]
    }

    newArray[0] = array.last()
//    newArray[newArray.lastIndex] = array.first()

    for (element in newArray) {
        print("$element ")
    }

    // write your code here
}