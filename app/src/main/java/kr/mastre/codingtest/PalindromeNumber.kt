package kr.mastre.codingtest

class PalindromeNumber {

    fun isPalindrome(x: Int): Boolean {
        val toString = x.toString().toList()
        val origin = toString.joinToString("")
        val reversed = toString.reversed().joinToString("")
        return origin == reversed
    }

}