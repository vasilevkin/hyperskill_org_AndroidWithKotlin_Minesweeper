fun parseCardNumber(cardNumber: String): Long {
    var throwException = false

    for (i in 0..cardNumber.length) {
        throwException = when (i) {
            4, 9, 14 -> cardNumber[i] != ' '
            in 0..3, in 5..8, in 10..13, in 15..18 -> !cardNumber[i].isDigit()
            else -> false
        }
    }

    if (throwException) throw Exception("Wrong number format")

    return cardNumber.trim().replace(" ", "", false).toLong()
}
