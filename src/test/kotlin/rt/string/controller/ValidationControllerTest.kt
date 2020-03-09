package rt.string.controller

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import rt.string.service.ValidatorService

@WebMvcTest(controllers = [ValidationController::class])
internal class ValidationControllerTest{
    @Autowired
    private lateinit var mockMvc: MockMvc

    @Test
    fun `given input string should return 200`(){

        val result = mockMvc.perform(
            get("/palindrome")
                .accept(APPLICATION_JSON)
        )

        result.andExpect(status().isOk)
    }
}