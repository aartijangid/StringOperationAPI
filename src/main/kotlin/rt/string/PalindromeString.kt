package rt.string

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash
import org.springframework.data.redis.core.index.Indexed

@RedisHash("PalindromeString")
data class PalindromeString (@Indexed val input: String, val isPalindrome: Boolean){
    @get:Id
    var id: String? = null
}