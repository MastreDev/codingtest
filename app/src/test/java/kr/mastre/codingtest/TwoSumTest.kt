package kr.mastre.codingtest

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class TwoSumTest : FunSpec({

    test("Two Sum") {
        val solution = TwoSum()
        val nums = intArrayOf(2, 7, 11, 15)
        val target = 9

        val result = solution.twoSum(nums, target)
        result shouldBe intArrayOf(0, 1)
    }

    test("Two Sum2") {
        val solution = TwoSum()
        val nums = intArrayOf(3, 2, 4)
        val target = 6

        val result = solution.twoSum(nums, target)
        result shouldBe intArrayOf(1, 2)
    }

    test("Two Sum3") {
        val solution = TwoSum()
        val nums = intArrayOf(3, 3)
        val target = 6

        val result = solution.twoSum(nums, target)
        result shouldBe intArrayOf(0, 1)
    }

})