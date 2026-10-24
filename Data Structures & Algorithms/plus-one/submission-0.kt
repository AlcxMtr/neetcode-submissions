class Solution {
    fun plusOne(digits: IntArray): IntArray {
        var index = digits.size - 1
        while (index >= 0 && digits[index] == 9) {
            digits[index] = 0
            index--
        }
        if (index != -1) {
            digits[index] = digits[index] + 1
        } else {
            return intArrayOf(1) + digits
        }
        return digits
    }
}
