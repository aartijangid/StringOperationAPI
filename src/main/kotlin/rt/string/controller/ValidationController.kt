package rt.string.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import rt.string.service.ValidatorService

@RestController
class ValidationController (val validatorService: ValidatorService){

    @GetMapping(value = ["/palindrome/{inputString}"])
    fun ifPalindrome(@PathVariable inputString: String) : Boolean {
        return validatorService.isPalindrome(inputString)
    }

}
