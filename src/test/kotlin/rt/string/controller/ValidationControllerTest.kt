package rt.string.controller

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test
import org.mockito.BDDMockito.given
import org.mockito.Mockito.verify
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import rt.string.service.ValidatorService

@WebMvcTest(controllers = [ValidationController::class])
internal class ValidationControllerTest{
    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockBean
    private lateinit var validatorService: ValidatorService

    @Test
    fun `given input string should return 200`(){
        val result = mockMvc.perform(
            get("/palindrome/testString")
                .accept(APPLICATION_JSON)
        )

        result.andExpect(status().isOk)
    }

    @Test
    fun `given input palindrome string should return true`(){

        val inputString = "testString"
        given(validatorService.isPalindrome(inputString)).willReturn(false)

        val result = mockMvc.perform(
            get("/palindrome/testString")
                .accept(APPLICATION_JSON)
                .contentType(APPLICATION_JSON)
        )

        result.andExpect(status().isOk)

        verify(validatorService).isPalindrome(inputString)

    }

}