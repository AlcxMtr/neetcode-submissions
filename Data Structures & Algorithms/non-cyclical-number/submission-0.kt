class Solution {
    fun isHappy(n: Int): Boolean {
        var num = n
        val set = mutableSetOf<Int>()
        while (num != 1) {
            if (set.contains(num)) return false
            set.add(num)
            val thousands: Int = num/1000
            num = num - thousands*1000
            val hundreds: Int = num/100
            num = num - hundreds*100
            val tens: Int = num/10
            num = num - tens*10
            val ones: Int = num
            num = (thousands*thousands + hundreds*hundreds 
             + tens*tens + ones*ones)
        }
        return true
    }
}
