import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class Test {
    private lateinit var bowling: Bowling

    @BeforeEach
    fun setUp() {
        bowling = Bowling()
    }

    @Test
    fun `spare should double the value in the next rolling`() {
        bowling.roll(5)
        bowling.roll(5)
        bowling.roll(5)
        assertEquals(bowling.calculateScore(), 20)
    }

    @Test
    fun `strike should double the value in the next frame`() {
        bowling.roll(10)
        bowling.roll(0)
        bowling.roll(5)
        bowling.roll(3)
        assertEquals(bowling.calculateScore(), 23)
    }

    @Test
    fun `More than 21 rollings should throw NoMoreRollingException`() {
        for (i in 0 until 21) {
            bowling.roll(0)
        }
        assertThrows<NoMoreRollingException> {
            bowling.roll(0)
        }
    }
    
    @Test
    fun `the rollings from the assignment example should yield the same score`() {
        bowling.roll(1)
        bowling.roll(4)
        bowling.roll(4)
        bowling.roll(5)
        bowling.roll(6)
        bowling.roll(4)
        bowling.roll(5)
        bowling.roll(5)
        bowling.roll(10)
        bowling.roll(0)
        bowling.roll(1)
        bowling.roll(7)
        bowling.roll(3)
        bowling.roll(6)
        bowling.roll(4)
        bowling.roll(10)
        bowling.roll(2)
        bowling.roll(8)
        bowling.roll(6)
        assertEquals(bowling.calculateScore(), 133)
    }

    @Test
    fun `roll 22 times should raise exception`() {
        assertThrows<NoMoreRollingException> {
            for (i in 0 until 23) {
                bowling.roll()
            }
        }
    }
}
