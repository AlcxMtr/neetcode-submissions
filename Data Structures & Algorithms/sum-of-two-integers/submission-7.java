class Solution {
    public int getSum(int a, int b) {
        int overflow = 0;
        int digit = 1;
        int result = 0;
        int maxDigit = 1 << 31;
        while (digit != 0) {
            int aDigit = digit & a;
            int bDigit = digit & b;
            int digitOverflow = digit & overflow;
            result |= aDigit ^ bDigit ^ digitOverflow;
            overflow |= ((aDigit & bDigit)
                | (aDigit & digitOverflow)
                | (bDigit & digitOverflow)) << 1;

            digit <<= 1;
        }
        return result;
    }
}
