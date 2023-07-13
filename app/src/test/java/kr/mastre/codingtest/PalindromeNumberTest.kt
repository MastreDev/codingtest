package kr.mastre.codingtest

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class PalindromeNumberTest : FunSpec({

    test("121 is true"){
        val solution = PalindromeNumber()
        val result = solution.isPalindrome(121)

        result shouldBe true
    }

    test("-121 is true"){
        val solution = PalindromeNumber()
        val result = solution.isPalindrome(-121)

        result shouldBe false
    }

    test("10 is true"){
        val solution = PalindromeNumber()
        val result = solution.isPalindrome(10)

        result shouldBe false
    }

})
