/**
 * [Число палиндром](https://leetcode.com/problems/palindrome-number/description/)
 *
 * @param x Целое число для проверки.
 * @return true, если x — палиндром, иначе false.
 */
fun isPalindrome(x: Int): Boolean {
    if (x < 0)
        return false
    else if (x == 0) {
        return true
    } else {
        var iterableNum = x.toLong()
        var reversedNum = ""
        while (iterableNum != 0L) {
            val currentLastDigit = iterableNum.mod(10)
            reversedNum += currentLastDigit
            iterableNum = iterableNum.div(10)
        }
        return reversedNum.toLong() == x.toLong()
    }
}

fun isPalindromeString(x: Int): Boolean {
    if (x < 0)
        return false
    else {
        val str = x.toString()
        val reversedNum = str.reversed().toInt()
        return reversedNum == x
    }
}

fun isPalindromeOptimization(x: Long): Boolean {
    if (x < 0)
        return false
    else if (x in 0L..9L)
        return true
    else {
        val list = arrayListOf<Int>()
        var number = x
        var count = 0
        while (number != 0L) {
            val currentLastDigit = number.mod(10)
            list.add(currentLastDigit)
            number = number.div(10)
            count++
        }

        for (i in 0..(count - 1) / 2) {
            if (list[i] != list[count - i - 1])
                return false
        }
        return true
    }
}

fun main() {
    val number = -2222L
    print(isPalindromeOptimization(number))
}