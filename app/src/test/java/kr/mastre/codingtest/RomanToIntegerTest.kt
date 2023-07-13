package kr.mastre.codingtest

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class RomanToIntegerTest : FunSpec({

    val solution = RomanToInteger()

    test("III then 3"){
        val result = solution.romanToInt("III")
        result shouldBe 3
    }

    test("LVIII then 58"){
        val result = solution.romanToInt("LVIII")
        result shouldBe 58
    }

    test("MCMXCIV then 1994"){
        val result = solution.romanToInt("MCMXCIV")
        result shouldBe 1994
    }

})
