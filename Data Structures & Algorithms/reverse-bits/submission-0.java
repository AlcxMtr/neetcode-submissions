class Solution {
    public int reverseBits(int n) {
        int top = 1 << 31;
        int bot = 1;
        int reversed = 0;
        for (int i = 0; i < 32; i++) {
            if ((bot & n) != 0) {
                reversed |= top;
            }
            top >>>= 1;
            bot <<= 1;
        }
        return reversed;
    }
}
