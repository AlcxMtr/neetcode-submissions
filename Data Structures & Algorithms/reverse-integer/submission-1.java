class Solution {
    public int reverse(int x) {
        String num = Integer.toString(x);
        String rev;
        if (x < 0) {
            rev = new StringBuilder(num.substring(1, num.length())).reverse().insert(0, "-").toString();
        } else {
            rev = new StringBuilder(num).reverse().toString();
        }
        long testBound = Long.valueOf(rev);
        if (testBound > Integer.MAX_VALUE || testBound < Integer.MIN_VALUE) return 0;
        return Integer.valueOf(rev);
    }
}
