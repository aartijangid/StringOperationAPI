package rt.string.service

class ValidatorService {
    fun isPalindrome(inputString: String): Boolean {
        val inputString: String = inputString.toUpperCase().replace("\\s".toRegex(), "")
        val hashSet: List<String> = inputString.toSet().map { it.toString() }
        val array: List<String> = inputString.toCharArray().map { it.toString() }
        val hashMap: HashMap<String, Int> = HashMap<String, Int>()

        array.forEachIndexed { i, s ->
            if(hashMap.containsKey(array[i]))
                hashMap[array[i]] = hashMap.getValue(array[i])+1
            else
                hashMap[array[i]] = 1
        }

        println(hashMap)
        var oddChar: Int = 0
        hashSet.forEach {
            if ((hashMap[it]?.rem(2)) == 1)
                oddChar++

            if (oddChar > 1)
                return false
        }

        return true;
    }

}
