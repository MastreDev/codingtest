package kr.mastre.codingtest

class TwoSum {

    fun twoSum(nums: IntArray, target: Int): IntArray {
        val storedNumbers = mutableMapOf<Int, Int>()
        for ((index, num) in nums.withIndex()) {
            if (storedNumbers.containsKey(num)) {
                return intArrayOf(storedNumbers[num]!!, index)
            } else {
                storedNumbers[target - num] = index
            }
        }
        return intArrayOf()
    }

}