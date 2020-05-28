import java.util.*

fun main() {
    println("Welcome to the bowling game!")
    println("Please type in 'r' for rolling, 'e' for exit")
    var input = Scanner(System.`in`).nextLine()
    val bowling = Bowling()
    while (true) {
        if (input == "r") {
            try {bowling.roll()} catch (e: NoMoreRollingException) {
                println("Game over")
                return
            }
            for (i in 0 until 21) {
                if (i % 2 == 0 || i == 19) {
                    print("${bowling.rollings[i]} ")
                } else {
                    print("${bowling.rollings[i]} | ")
                }
            }
            println()
            println("Total score: ${bowling.calculateScore()}")
            input = Scanner(System.`in`).nextLine()
        } else if (input == "e") {
            return
        }
    }
}
