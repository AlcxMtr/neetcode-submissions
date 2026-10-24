class Solution {
    fun myPow(x: Double, n: Int): Double {
        var num = x;
        if (x == 1.0) {
            return 1.0
        } else if (x == -1.0) {
            if (n%2 == 0) {
                return 1.0
            } else {
                return -1.0
            }
        }

        if (n < -10000) {
            return 0.0
        }

        if (n == 0) {
            num = 1.0
        } else if (n > 0) {
            for (i in 2..n) {
                num = num*x
            }
        } else if (n < 0) {
            for (i in n..0) {
                num = num/x
            }
        }
        return num
    }
}
