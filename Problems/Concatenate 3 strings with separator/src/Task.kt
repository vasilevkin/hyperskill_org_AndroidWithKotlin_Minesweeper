fun main() {
    val string1 = readLine()!!
    val string2 = readLine()!!
    val string3 = readLine()!!
    val separator = readLine()!!

    val resultString = if (separator == "NO SEPARATOR") {
        concatenateThreeStrings(string1, string2, string3)
    } else {
        concatenateThreeStrings(string1, string2, string3, separator)
    }

    print(resultString)
}

fun concatenateThreeStrings(s1: String, s2: String, s3: String, separator: String = " "): String =
        "$s1$separator$s2$separator$s3"
