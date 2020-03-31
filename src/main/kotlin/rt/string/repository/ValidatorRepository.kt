package rt.string.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import rt.string.PalindromeString

@Repository
interface  ValidatorRepository : CrudRepository<PalindromeString, String>