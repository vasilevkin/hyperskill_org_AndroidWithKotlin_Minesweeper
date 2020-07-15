fun main() {
    try {
        val index = readLine()!!.toInt()
        val word = readLine()!!
        println(word[index])
    } catch (e: Exception) {
        print("There isn't such an element in the given string, please fix the index!")
    }
}
