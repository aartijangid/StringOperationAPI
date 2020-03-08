package rt.string.service

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class ValidatorServiceTest {
    private lateinit var validatorService: ValidatorService

    @Test
    fun `given palindrome string should return true`(){
        val inputString = "Mr Owl Ate My Metal Worm"
        validatorService = ValidatorService()
        assertEquals(true, validatorService.isPalindrome(inputString))
    }

    @Test
    fun `given nonPalindrome string should return false`(){
        val inputString = "Mr Owl Ate My Metal Worms"
        validatorService = ValidatorService()
        assertEquals(false, validatorService.isPalindrome(inputString))
    }
}