import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    val quantity = scanner.nextInt()

    var length = 0
    var maxLength = 0
//    val array = IntArray(quantity)

//    val array = IntArray(quantity)
//
//    for (i in 1 until quantity) {
//        array[i] = scanner.nextInt()
//    }


    var previousNumber = 0
    repeat(quantity) {

        val number = scanner.nextInt()

        if(number >= previousNumber) {
            length++
        } else {
            if (length > maxLength)
                maxLength = length
            length = 1
        }
//        if (array.size > 1) {
//            if(array[it-1] <= array[it]) {
//                length++
//            } else
//                if (maxLength < length) {
//                    maxLength = length
//                    length = 0
//                }
//
//        }

        previousNumber = number

    }

    print(maxLength)


    // write your code here
}