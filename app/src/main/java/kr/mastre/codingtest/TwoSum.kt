package kr.mastre.codingtest

class TwoSum {

    fun twoSum(nums: IntArray, target: Int): IntArray {
        val undered = nums.withIndex()
        var resultLeft: Int? = null
        var resultRight: Int? = null

        for (indexedValue in undered) {
            val willRight = (target - indexedValue.value)
            val result = undered.find { xx -> xx.value == willRight && xx.index != indexedValue.index }
            if (result != null) {
                resultLeft = indexedValue.index
                resultRight = result.index
                break
            }
        }
        return intArrayOf(resultLeft!!, resultRight!!)
    }
}