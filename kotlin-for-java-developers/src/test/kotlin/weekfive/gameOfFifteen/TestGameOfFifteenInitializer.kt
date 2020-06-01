package weekfive.gameOfFifteen

import org.junit.Assert
import org.junit.Test
import weekfive.games.gameOfFifteen.RandomGameInitializer
import weekfive.games.gameOfFifteen.isEven

class TestGameOfFifteenInitializer {
    @Test
    fun testInitialPermutationIsNotTrivial() {
        val initializer = RandomGameInitializer()
        Assert.assertNotEquals(
            "The initial permutation must not be trivial",
            (1..15).toList(), initializer.initialPermutation
        )
    }

    @Test
    fun testInitialPermutationIsEven() {
        val initializer = RandomGameInitializer()
        Assert.assertNotEquals(
            "The initial permutation must be even",
            isEven(initializer.initialPermutation)
        )
    }
}