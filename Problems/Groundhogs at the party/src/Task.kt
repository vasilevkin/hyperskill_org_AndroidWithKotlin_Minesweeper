import java.util.*

import java.math.BigInteger

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    val cups = scanner.nextInt()
    val weekend = scanner.nextBoolean()

    val successfulParty = when {
        cups in 10..20 && !weekend -> true
        cups in 15..25 && weekend -> true
        else -> false
    }

    print(successfulParty)
    // write your code here


    var a = BigInteger("1")                                //1
    var b = BigInteger.valueOf(62957291795228763406253098) //2
    var c = a++                                            //3
    var d = a+1                                            //4
    var e = ++BigInteger.ONE                               //5

    val one = BigInteger(1)

    val one2 = BigInteger.ONE

    val one3 = BigInteger.valueOf(1)

    val one4: BigInteger = 1
}