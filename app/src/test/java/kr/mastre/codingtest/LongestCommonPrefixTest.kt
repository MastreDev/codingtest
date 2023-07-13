package kr.mastre.codingtest

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class LongestCommonPrefixTest : FunSpec({

    val solution = LongestCommonPrefix()

    test("[\"flower\",\"flow\",\"flight\"] will return fl") {
        val arrays = arrayOf("flower","flow","flight")

        val result = solution.longestCommonPrefix(arrays)

        result shouldBe "fl"
    }

    test("[\"dog\",\"racecar\",\"car\"] will return empty") {
        val arrays = arrayOf("dog","racecar","car")

        val result = solution.longestCommonPrefix(arrays)

        result shouldBe ""
    }

    test("[\"cir\",\"car\"] will return c") {
        val arrays = arrayOf("cir","car")

        val result = solution.longestCommonPrefix(arrays)

        result shouldBe "c"
    }

})
