fun main() {
    printGreetUser()
}

fun printGreetUser(name: String = "secret user") =
        print("Hello, $name!")