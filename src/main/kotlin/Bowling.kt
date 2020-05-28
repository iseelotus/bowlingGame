import kotlin.random.Random

class Bowling{
    val MAXIMUM_SCORE_PER_FRAME = 10
    val NUMBER_OF_FRAMES = 10
    var rollings = IntArray(NUMBER_OF_FRAMES*2 + 1)
    var counterRoll = 0

    fun calculateScore(): Int {
        var score = 0
        for (i in 0 until NUMBER_OF_FRAMES - 1) {
            if (isStrike(i)) {
                score += (10 + rollings[2*i + 2] + rollings[2*i + 3])
            } else if (isSpare(i)){
                score += (10 + rollings[2*i + 2])
            } else {
                score += (rollings[2*i] + rollings[2*i + 1])
            }
        }
        score += rollings[NUMBER_OF_FRAMES*2-2] + rollings[NUMBER_OF_FRAMES*2-1] + rollings[NUMBER_OF_FRAMES*2]
        return score
    }

    fun roll() {
        roll(Random.nextInt(0, 11))
    }

    fun roll(roll: Int) {
        if (counterRoll < rollings.size) {
            if (counterRoll % 2 == 0) {
                rollings[counterRoll] = roll
                if (roll == 10) {
                    counterRoll += 2
                } else {
                    counterRoll++
                }
            } else if (counterRoll % 2 == 1) {
                if (roll + rollings[counterRoll-1] <= 10) {
                    rollings[counterRoll] = roll
                } else {
                    rollings[counterRoll] = Random.nextInt(0, 11 - rollings[counterRoll-1])
                }
                counterRoll++
            }
        } else {
            throw NoMoreRollingException("Game over")
        }
    }

    private fun isSpare(frame: Int): Boolean {
        return (rollings[frame*2] + rollings[frame*2 + 1] == MAXIMUM_SCORE_PER_FRAME)
    }

    private fun isStrike(frame: Int): Boolean {
        return (rollings[frame*2] == MAXIMUM_SCORE_PER_FRAME)
    }
}
