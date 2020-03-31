package rt.string.service

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.BDDMockito.any
import org.mockito.BDDMockito.given
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import rt.string.PalindromeString
import rt.string.repository.ValidatorRepository

@ExtendWith(MockitoExtension::class)
internal class ValidatorServiceTest {
    private lateinit var validatorService: ValidatorService

    @Mock
    lateinit var repository: ValidatorRepository

    @BeforeEach
    fun setUp() {
        validatorService = ValidatorService(repository)
    }

    @Test
    fun `given palindrome string exists should return true`(){
        val inputString =  "KAYAK"// "Mr Owl Ate My Metal Worm"
        val expectedOutPut = PalindromeString(inputString, true)
        given(repository.existsById(inputString)).willReturn(false)
        given(repository.save(any<PalindromeString>())).willReturn(PalindromeString(inputString, true))
        assertEquals(expectedOutPut, validatorService.isPalindrome(inputString))
    }

    @Test
    fun `given nonPalindrome string should return false`(){
        val inputString =  "KAYAKY"//"Mr Owl Ate My Metal Worms"
        val expectedOutPut = PalindromeString(inputString, false)
        given(repository.existsById(inputString)).willReturn(false)
        given(repository.save(any<PalindromeString>())).willReturn(PalindromeString(inputString, true))
        assertEquals(expectedOutPut, validatorService.isPalindrome(inputString))
    }
}