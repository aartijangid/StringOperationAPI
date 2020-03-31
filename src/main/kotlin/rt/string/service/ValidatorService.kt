package rt.string.service

import org.springframework.stereotype.Service
import rt.string.PalindromeString
import rt.string.repository.ValidatorRepository

@Service
class ValidatorService (val validatorRepository: ValidatorRepository) {

    fun isPalindrome(inputString: String): PalindromeString {
        var dummyInputString = inputString
        var result: PalindromeString
        var isPalindrome: Boolean = false
        if (validatorRepository.existsById(dummyInputString)) {
            result = validatorRepository.findById(dummyInputString).get()
        } else {
            val dummyInputString: String = dummyInputString.toUpperCase().replace("\\s".toRegex(), "")
            val hashSet: List<String> = dummyInputString.toSet().map { it.toString() }
            val array: List<String> = dummyInputString.toCharArray().map { it.toString() }
            val hashMap: HashMap<String, Int> = HashMap<String, Int>()

            array.forEachIndexed { i, s ->
                if (hashMap.containsKey(array[i]))
                    hashMap[array[i]] = hashMap.getValue(array[i]) + 1
                else
                    hashMap[array[i]] = 1
            }
            println(hashMap)

            var oddChar: Int = 0
            hashSet.forEach {
                if ((hashMap[it]?.rem(2)) == 1) {
                    oddChar++
                }
                println(oddChar)
                if (oddChar == 1)
                    isPalindrome = true
            }
            println(isPalindrome)
            result = PalindromeString(inputString, isPalindrome);
            validatorRepository.save(result)
        }
        return result
    }
}
