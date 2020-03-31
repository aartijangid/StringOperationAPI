package rt.string

import org.springframework.data.redis.core.RedisHash

@RedisHash("PalindromeString")
data class PalindromeString (val input: String, val isPalindrome: Boolean){

}