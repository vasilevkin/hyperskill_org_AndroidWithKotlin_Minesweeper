import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    val size = scanner.nextInt()
    var array = IntArray(size)

    for (i in 0..array.lastIndex) {
        array[i] = scanner.nextInt()
    }

    val shifts = scanner.nextInt()

    var newArray = IntArray(size)

    repeat(shifts) {

        newArray = shiftArray(array)
//        for (i in 1..array.lastIndex) {
//            newArray[i] = array[i - 1]
//        }
//        newArray[0] = array[array.lastIndex]
//
//        array = newArray
    }

    for (i in 0..newArray.lastIndex) {
//    for (i in 0..array.lastIndex) {
        print("${array[i]} ")
    }

    // write your code here
}

fun shiftArray(array: IntArray): IntArray {
    val newArray = IntArray(array.size)

    for (i in 1..array.lastIndex) {
        newArray[i] = array[i - 1]
    }
    newArray[0] = array[array.lastIndex]

    return newArray
}