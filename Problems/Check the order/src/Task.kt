import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    val quantity = scanner.nextInt()

    var ascending = true

    val numbersArray = IntArray(quantity)
    repeat(quantity) {
        numbersArray[it] = scanner.nextInt()
        if (it != 0) {
            if (numbersArray[it - 1] > numbersArray[it])
                ascending = false
        }
    }
//
//    var result = ""
//
//    for (i in 1..quantity) {
//        result += i
//    }

    if (ascending == true)
        print("YES")
    else
        print("NO")

    // write your code here
}
